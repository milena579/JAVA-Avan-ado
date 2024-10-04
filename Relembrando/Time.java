package Relembrando;
public class Time {
    static final long secondTicks = 1000;
    static final long minuteTicks = 1000 * 60;
    static final long hourTicks = 1000 * 60 * 60;
    static final long dayTicks = hourTicks * 24;
    final long yearTicks = dayTicks * 365;
    
    private long ticks = 0;

    public Time (long ticks){
        this.ticks = ticks;
    }

    public Time (Time time){
        this.ticks = time.ticks;
    }

   public Time (int year, int dayOfYear, int hour, int minute, int second){
        this.ticks = 
        yearTicks * year + dayTicks * dayOfYear + 
        hourTicks * hour + minuteTicks * minute + secondTicks * second;
   }

   public int getYear(){
    return(int)(ticks / yearTicks) + 1970;
   }

   public int getDay(){
        int rest = (int)(ticks % yearTicks);
        return (int)(rest / dayTicks);
   }
   public int getHour(){
        long rest = ticks % dayTicks;
        return (int)(rest / hourTicks);
   }

   public int getMinute(){
        long rest = ticks % minuteTicks;
        return (int)(rest/ minuteTicks);
   }
   
   public int getSeconds(){
        long rest = ticks % secondTicks;
        return (int)(rest/secondTicks);
   }

   public void addSeconds(int seconds){
        this.ticks += secondTicks + seconds;
   }

   public int getTotalSeconds(){
    return (int)(ticks / 1000);
   }

   public boolean isBiggetThan(Time other){
        return this.ticks > other.ticks;
   }

   public static Time now(){
        int ticksCaldulados = 0;
        return new Time(ticksCaldulados);
   }
}
