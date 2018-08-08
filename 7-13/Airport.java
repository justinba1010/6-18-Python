public class Airport
{
   private Plane[] runway;
   public Airport(int size){
       if(size<0){
           System.out.println("Can not have negative runways");
           return;
        }
        this.runway = new Plane[size];
    }
    public void addPlane(int runway, String name, int capacity){
        if(runway < 0 || runway >= this.runway.length){
            System.out.println("Runway does not exist.");
            return;
        }
        this.runway[runway] = new Plane(name, capacity);
    }
       public void flyPlane(int runway){
        if(runway < 0 || runway >= this.runway.length){
            System.out.println("Runway does not exist.");
            return;
        }
        Plane aPlane = this.runway[runway];
        aPlane.fly();
        aPlane.printStatus();
    }
     public void landPlane(int runway){
        if(runway < 0 || runway >= this.runway.length){
            System.out.println("Runway does not exist.");
            return;
        }
        Plane aPlane = this.runway[runway];
        aPlane.land();
        aPlane.printStatus();
    }
    public void expand(int numRunways){
        Plane[] newRunway = new Plane[this.runway.length+numRunways];
        for(int i = 0; i < this.runway.length; i++) {
            newRunway[i] = this.runway[i];
        }
        this.runway = newRunway;
        System.out.println("Expand");
    }

    public void status(){
        for(int i = 0; i <= this.runway.length-1; i++){
            Plane iPlane = this.runway[i];
            if(iPlane != null) iPlane.printStatus();
        }
    }
      public class Plane{
            private String model;
            private int capacity;
            private boolean isAir;
            public Plane(String model, int capacity){
                this.model = model;
                this.capacity = capacity;
                this.isAir = false;
            }
            public String getModel(){
                return this.model;
            }
            public void setModel(String plane){
                this.model = plane;
            }
            public int getCapacity(){
                return this.capacity;
            }
            public void setCapacity(int capacity){
                this.capacity = capacity;
            }
           public void printStatus(){
               if(this.isAir){
                   System.out.println("Plane"+ this.model + "is in the air");
                }else{
                   System.out.println("Plane"+ this.model + "is on ground");
                }
            }
            public void fly() {
                this.isAir = true;
            }
            public void land() {
                this.isAir = false;
            }

        }
}
