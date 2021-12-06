public  class NBody {
    public static double readRadius(String planetsTxtPath) {
        try {
            In in = new In(planetsTxtPath);

            if (!in.isEmpty()) {
                in.readLine();
            }
            if (!in.isEmpty()) {
                return in.readDouble();
            }
        }
        catch (Exception e) { System.out.println(e); 
        }
        return 0;
    }
    public static Planet[] readPlanets(String planetsTxtPath) {
        Planet[] returPlanet = null;
        try {
            In in = new In(planetsTxtPath);
            int s;
            if (!in.isEmpty()) {
                s = in.readInt();
                returPlanet = new Planet[s];
            }
            if (!in.isEmpty()) {
                in.readLine();
                in.readLine();
                //return Double.parseDouble(s);
            }
            for (int i = 0; i < returPlanet.length; i++) {
                if (!in.isEmpty()) {
                    //String tmp = in.readLine();
                    double xxPos = in.readDouble();
                    double yyPos= in.readDouble();
                    double xxVel = in.readDouble();
                    double yyVel= in.readDouble();
                    double mass = in.readDouble();
                    String imgFileName = in.readString();
                    returPlanet[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
                } 
                
            }            
        }
        catch (Exception e) { System.out.println(e); 
        }
        return returPlanet;
    }
}
