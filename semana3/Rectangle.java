public class Rectangle{
   int x1, x2, y1, y2;
   public Rectangle(int x1, int y1, int x2, int y2){
      this.x1 = x1; this.x2 = x2; this.y1 = y1; this.y2 = y2;      
   }
   public Rectangle(Point p1, Point p2){
      this.x1 = p1.x; this.x2 = p2.x; this.y1 = p1.y; this.y2 = p2.y;      
   }
   public int area(){
      return (x2-x1)*(y2-y1);
   }
   public int perimeter(){
      return 2*(x2-x1) + 2*(y2-y1);
   }
   public boolean pointInside(Point p){
      return (p.x >= x1 && p.x <= x2) && (p.y >= y1 && p.y <= y2); 
   }
   public boolean rectangleInside(Rectangle r){
      return r.x1 >= this.x1  && r.x2 <= this.x2  && r.y1 >= this.y1  && r.y2 <= this.y2;
   }
}
