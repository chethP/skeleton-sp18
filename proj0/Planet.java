import java.util.function.DoubleToIntFunction;

/**
 * 行星类
 */
public class Planet {
    public double xxPos;//x坐标
    public double yyPos;//y
    public double xxVel;//x方向
    public double yyVel;//y
    public double mass;//堆？
    public String imgFileName;//图片名字
    public Planet(double xxPos, double yyPos, double xxVel,double yyVel, double mass, String imgFileName)
    {
        this.xxPos=xxPos;
        this.yyPos=yyPos;
        this.xxVel=xxVel;
        this.yyVel=yyVel;
        this.mass=mass;
        this.imgFileName=imgFileName;
    }

    public Planet(Planet p){
        this(p.xxPos, p.yyPos, p.xxVel, p.yyVel,p.mass, p.imgFileName);
    }
    public double calcDistance(Planet p) {
        double x=Math.pow(p.xxPos - this.xxPos, 2); 
        double y=Math.pow(p.yyPos - this.yyPos, 2);
        double r=Math.pow(x + y, 0.5);
        
        return r;
    }
    
    public double calcForceExertedBy(Planet p) {
        double r=calcDistance(p);
        double g = 6.67e-11;
        double f = g * this.mass * p.mass / r / r;
        return f;
    }
    public double calcForceExertedByX(Planet p) {
        double f = calcForceExertedBy(p);
        double dx= p.xxPos - this.xxPos;
        double r = calcDistance(p);

        return f * dx / r;
    }
    
    public double calcForceExertedByY(Planet p) {
        double f = calcForceExertedBy(p);
        double dy= p.yyPos-this.yyPos;
        double r = calcDistance(p);
        return  f * dy / r;
    }
    public double calcNetForceExertedByX(Planet[] ps) {
        double sum=0;
        for (Planet planet : ps) {
            if(!this.equals(planet)){
                sum += calcForceExertedByX(planet);
            }
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double sum=0;
        for (Planet planet : ps) {
            if(!this.equals(planet)){
                sum+=calcForceExertedByY(planet);
            }
        }
        return sum;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel = xxVel + dt * ax;
        yyVel = yyVel + dt * ay;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel; 
    }
}