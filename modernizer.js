function canvasSupport () {
    return Modernizr.canvas;
}

function canvasApp() 
{
    
    if (!canvasSupport()) {  
        return;
    }
  
    
    function drawScreen () 
    {   
        context.globalCompositeOperation = "source-over";
        context.fillStyle = "rgba(0, 0, 0, 0.3)";
        context.fillRect(0, 0, theCanvas.width, theCanvas.height);
	      //context.globalCompositeOperation = "lighter";
        
        var gradient = context.createRadialGradient( 
          theCanvas.width * 0.5, 
          theCanvas.height * 0.5, 
          0, 
          theCanvas.width * 0.5, 
          theCanvas.height * 0.5, 500 
        );
        
        gradient.addColorStop(0,'rgba(0, 70, 70, 1)');
		    gradient.addColorStop(1,'rgba(0, 8, 14, 1)');
		
		    context.fillStyle = gradient;
		    context.fillRect( 0, 0, theCanvas.width, theCanvas.height );
      
        var ball;
        
        for (var i = 0; i < balls.length; i++ ) 
        {
            var current = i;
          
            ball = balls[i];
            ball.x += ball.xunits;
            ball.y += ball.yunits;
            context.beginPath();
          
            var gradient = context.createRadialGradient(
              ball.x, ball.y, 0, ball.x, ball.y, ball.radius
            );
            
            gradient.addColorStop(0, "rgba(255,255,255,0.75)");
            gradient.addColorStop(0.4, "rgba(255,255,255,0.75)");
            gradient.addColorStop(0.4, ball.color);
		        context.fillStyle = gradient;
		
            context.arc(ball.x,ball.y,ball.radius,0,Math.PI*2,true);
            
            context.shadowColor = '#999'; 
            context.shadowBlur = 30;
            context.shadowOffsetX = 10;
            context.shadowOffsetY = 15;
          
            context.closePath();
            context.fill();
                
            if (ball.x > theCanvas.width || ball.x < 0 ) {
                ball.angle = 180 - ball.angle;
                updateBall(ball);
            } else if (ball.y > theCanvas.height || ball.y < 0) {
                ball.angle = 360 - ball.angle;
                updateBall(ball);
            } 
          
          
            for (var z = 0; z < balls.length; z++ ) 
            {
                if( z != i )
                {
                    /*
                    *  balls connecting
                    */
                    var zxLower  = balls[z].x - distance,
                        zxHigher = balls[z].x + distance,
                        zyLower  = balls[z].y - distance,
                        zyHigher = balls[z].y + distance
                  
                    if( balls[i].x >= zxLower  && balls[i].x <= zxHigher  && 
                        balls[i].y >= zyLower  && balls[i].y <= zyHigher) {
                   
                      context.beginPath();
                      context.strokeStyle = 'rgba(255,255,255,0.5)';
                      context.moveTo(balls[i].x , balls[i].y );
                      context.lineTo(balls[z].x , balls[z].y );
                      context.stroke();
                    } 
                  
                    /*
                    *  balls bouncing
                    */
                    var zxLower  = balls[z].x - (balls[z].radius),
                        zxHigher = balls[z].x + (balls[z].radius),
                        zyLower  = balls[z].y - (balls[z].radius),
                        zyHigher = balls[z].y + (balls[z].radius)
                  
                    if( balls[i].x >= zxLower  && balls[i].x <= zxHigher  && 
                        balls[i].y >= zyLower  && balls[i].y <= zyHigher) {
                        
                        balls[i].angle = 180 - balls[i].angle;
                        updateBall(balls[i]);
                      
                        balls[z].angle = 180 - balls[z].angle;
                        updateBall(balls[z]);
                    }
                }
            }
        }
    }
  
    function updateBall(ball){
        ball.radians = ball.angle * Math.PI/ 180;
        ball.xunits = Math.cos(ball.radians) * ball.speed;
        ball.yunits = Math.sin(ball.radians) * ball.speed;
    }
    
    var numBalls = 10,
        minSize = 14,
        maxSize = 14,
        maxSpeed = (maxSize+1),
        balls = new Array(),
        tempBall,
        tempX,
        tempY,
        tempSpeed,
        tempAngle,
        tempRadius,
        tempRadians,
        tempXunits,
        tempYunits,
        tempColor,
        distance = 150,
        speedDiff = 4; 
    
    var theCanvas = document.getElementById("canvas"),
        context = theCanvas.getContext("2d");
  
   
    for(var i=0; i<numBalls; i++){
      
        tempRadius = Math.floor(Math.random()*maxSize)+minSize;
        tempX = tempRadius*2 + (Math.floor(Math.random()*theCanvas.width)-tempRadius*2);
        tempY = tempRadius*2 + (Math.floor(Math.random()*theCanvas.height)-tempRadius*2);
        tempSpeed = (maxSpeed-tempRadius) + speedDiff;
        tempAngle = Math.floor(Math.random()*360);
        tempRadians = tempAngle * Math.PI/ 180;
        tempXunits = Math.cos(tempRadians) * tempSpeed;
        tempYunits = Math.sin(tempRadians) * tempSpeed;
        tempColor = "rgba(255, 20, 147, 0.5)";
	    
        tempBall = {
                 x:tempX
                ,y:tempY
                ,radius:tempRadius 
                ,speed:tempSpeed
                ,angle:tempAngle
                ,xunits:tempXunits
                ,yunits:tempYunits
                ,color:tempColor
        }
        
        balls.push(tempBall);
    } 
    
    function loop() {
        window.setTimeout(loop, 20);
        drawScreen();
    }
  
    loop();
}

canvasApp();