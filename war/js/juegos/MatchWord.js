/**
 * @author Erick Suarez
 */

function MatchGame (canvas, images) {
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
                alert("0");
            } else if (self.jugador.collide (self.objetos[1])){
                alert("1");
            } else if (self.jugador.collide (self.objetos[2])){
                alert("2");
            }
        };   
    }
    
    this.resize = function() {
        this.escenario = document.getElementById("canvas");        
        this.escenario.width = window.innerWidth * 0.8;
        this.escenario.height = window.innerHeight * 0.8;
        this.cWidth = this.escenario.width;
        this.cHeight = this.escenario.height;
        this.rectW = this.cWidth * 0.25;
        this.rectH = this.cWidth * 0.25;
        this.espacio = this.cWidth * 0.0625;
        
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

    this.init = function() {        
        self.resize ();
        self.initObjects ();
        self.registerEvents ();
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
        this.ctx.strokeRect(0, 0, this.cWidth, this.cHeight);
        this.ctx.restore();

    };

    this.main = function() {
        self.setBackground();
        self.drawImages();
    };

    

    this.drawImages = function() {
        for (var i = 0; i < this.objetos.length; i++) {
            this.objetos[i].draw (this.ctx);    
        }
        this.jugador.draw(this.ctx);
    };
}



