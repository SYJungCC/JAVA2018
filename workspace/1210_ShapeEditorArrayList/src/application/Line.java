package application;

public class Line extends Shape {
     private Point _start;
     private Point _end;

     public Line (Point newStart, Point newEnd){
    	 this._start = newStart;
    	 this._end = newEnd;
     }

     @Override
     public void draw(){
    	 System.out.println( "name: " + this._name + ", "
    	 		+ "Start :("  + this._start.getX() +", "+
		                        this._start.getY() + "), " +
		                     " End :("  + this._end.getX() +","+
		                        this._end.getY() + ")");

     }

}
