
function MatchWord (canvas, images) {//se declaran las variables
	this.canvas = canvas;
    this.ctx = canvas.getContext("2d");
    this.cWidth;
    this.cHeight;
    this.escenario;    
    this.rectW;
    this.rectH; 
    this.objetos=[];
    this.jugador;
    this.espacio;
    this.images = images;
    var self = this;
    this.score = 0;
    this.time = 0;
    this.min = 0;
    this.hours = 0;
    //variable para insert o update de la informaciòn
    this.terminado = true;
    this.error = 0;
    
    this.registerEvents = function (){
        this.canvas.onmousedown = function(event) {
            self.objetos[0].click (event);  
            self.objetos[1].click (event);
            self.objetos[2].click (event);
        };

        this.canvas.onmousemove = function(event) {
            self.objetos[0].move (event);
            self.objetos[1].move (event);
            self.objetos[2].move (event);
        };

        this.canvas.onmouseup = function(event) {    
            self.objetos[0].unclick (event);
            self.objetos[1].unclick (event);
            self.objetos[2].unclick (event);
            
            if (self.jugador.collide (self.objetos[0])){
            	self.score += 10;
            	$('#acierto').modal({
                    keyboard: true,
                    show: true,
                    backdrop: 'static'
                });
            	self.guardar();
            } else if (self.jugador.collide (self.objetos[1])){
            	self.score -= 3;
            	$('#error').modal('show');
                self.initObjects();
                self.error++;
            } else if (self.jugador.collide (self.objetos[2])){
            	self.score -= 3;
            	$('#error').modal('show');
                self.initObjects();
                self.error++;
            }
        };   
    }
    
    this.resize = function() {// funcion para hacer responsivo el canvas 
        this.escenario = document.getElementById("canvas");        
        this.escenario.width = window.innerWidth * 0.8;
        this.escenario.height = window.innerHeight * 0.8;
        this.cWidth = this.escenario.width;
        this.cHeight = this.escenario.height;
        this.rectW = this.cWidth * 0.25;//estas dos variables son para el ancho y alto de las imagenes
        this.rectH = this.cWidth * 0.25;
        this.espacio = this.cWidth * 0.0625;
        this.alto   = this.cHeight * 0.0625;
    };

    this.initObjects = function(){
        x = this.espacio;
        
        this.jugador = new GameObject (this.images[0], this.rectW+2*(this.espacio), 10, this.rectW, this.rectH);
        
        this.objetos[0] = new GameObject(this.images[1], x, this.rectH+20, this.rectW, this.rectH);
        x += this.rectW+this.espacio;
        
        this.objetos[1] = new GameObject(this.images[2], x, this.rectH+20, this.rectW, this.rectH);
        x += this.rectW+this.espacio;
        
        this.objetos[2] = new GameObject(this.images[3], x, this.rectH+20, this.rectW, this.rectH);
        x -= this.rectW+this.espacio;          
    };

    this.init = function() {        //esta es la primera funcion que se manda llamar
        self.resize ();
        self.initObjects ();
        self.registerEvents ();
        self.timer();

        if (typeof game_loop != "undefined") {
            clearInterval();
        }
        game_loop = setInterval(this.main, 30);
    };

    this.setBackground = function() {

        this.ctx.save();
        this.ctx.fillStyle = "white";
        this.ctx.fillRect(0, 0, this.cWidth, this.cHeight);
        this.ctx.strokeStyle = "#000000";
        this.ctx.lineWidth = 3;
        this.ctx.strokeRect(0, 0, this.cWidth, this.cHeight);
        this.ctx.restore();

    };

    this.drawScore = function(){

        var text = "Puntos: " + self.score;
        var time = "Tiempo: " + self.hours + " : " + self.min + " : " + self.time;

        self.ctx.font = "20px Arial";
        self.ctx.fillStyle = "black";
        self.ctx.fillText(text,this.espacio,this.rectH+200);
        self.ctx.fillText(time,this.espacio,this.rectH+240)
    };

    this.timer = function(){


        setInterval(function(){
                    self.time++;

                    if(self.time === 60){
                        self.time = 0;
                        self.min++;
                    }else if(this.min === 60){
                        self.min = 0;
                        self.hours++;
                    }
                },
                1000);
    }

    this.main = function() {
        //self.time ++;
        self.setBackground();
        self.drawImages();
        self.drawScore();
    };

    

    this.drawImages = function() {
        for (var i = 0; i < this.objetos.length; i++) {
            this.objetos[i].draw (this.ctx);    
        }
        this.jugador.draw(this.ctx);
    };
    
    this.guardar = function(){

            insertAvance(self.hours + " : " + self.min + " : " + self.time
            			,true,self.error,self.score);

        
    };
}



