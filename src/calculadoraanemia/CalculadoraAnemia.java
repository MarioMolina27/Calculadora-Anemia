/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraanemia;

/**
 *
 * @author molin
 */
public class CalculadoraAnemia {

    public static final double NIVELL_MIN1 = 11,
                               NIVELL_MIN2 = 11.5,
                               NIVELL_MIN3 = 12,
                               NIVELL_MIN4 = 14;
    
    public static final double NIVELL_MAX1 = 15,
                               NIVELL_MAX2 = 15.5,
                               NIVELL_MAX3 = 16,
                               NIVELL_MAX4 = 18;
    
    public static void main(String[] args) {
        int edat;
        char sexe; // h --> home  d -->dona
        float nivellHemoglobina;
        double NivellMin,NivellMax;
        
        System.out.print("Edat? ");
        edat = Teclat.llegirInt();
        
        do{
            System.out.print("Sexe? ");
            sexe = Teclat.llegirChar();
        }while(sexe!='d'&&sexe!='h');
        
        System.out.print("Hemoglobina? ");
        nivellHemoglobina = Teclat.llegirFloat();
        
        NivellMax = nivellMaxHemoglobina (edat,sexe);
        NivellMin = nivellMinHemoglobina (edat,sexe);
        
        System.out.println("El nivell màxim de Hemoglobina hauría de ser de "+ NivellMax );
        System.out.println("El nivell mínim de Hemoglobina hauría de ser de "+ NivellMin );
        
        if(teAnemia(NivellMin,NivellMax,nivellHemoglobina)=='s'){
            System.out.println("El pacient té anémia");
        }
        else if(teAnemia(NivellMin,NivellMax,nivellHemoglobina)=='n'){
            System.out.println("El pacient no té anémia");
        }
    }
    
    static double nivellMaxHemoglobina (int edat, char sexe){
        double nivellMax=0;
        if(edat<=1){
            nivellMax = NIVELL_MAX1;
        }
        else if(edat>1&&edat<=15){
            nivellMax = NIVELL_MAX2;
        }
        else if (edat>15){
            if(sexe=='h'){
                nivellMax = NIVELL_MAX4;
            }
            if(sexe=='h'){
                nivellMax = NIVELL_MAX3;
            }
        }
    return nivellMax;
    }
    static double nivellMinHemoglobina (int edat, char sexe){
        double nivellMin=0;
        if(edat<=1){
            nivellMin = NIVELL_MIN1;
        }
        else if(edat>1&&edat<=15){
            nivellMin = NIVELL_MIN2;
        }
        else if (edat>15){
            if(sexe=='h'){
                nivellMin = NIVELL_MIN4;
            }
            if(sexe=='h'){
                nivellMin = NIVELL_MIN3;
            }
        }
    return nivellMin;
    }
    static char teAnemia(double NivellMin, double NivellMax, float nivellHemoglobina){
        char teAnemia=' ' ; // s --> Anemia  n--> No Anemia
        if(nivellHemoglobina>NivellMax){
            teAnemia = 's';
        }
        else if(nivellHemoglobina<NivellMin){
            teAnemia = 's';
        }
        else{
            teAnemia = 'n';
        }
    return teAnemia;
    } 
}
