
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        pantallaInicial();
    }

    public static void pantallaInicial() {
        String[] conversores = {"Conversor de Moneda", "Conversor de Temperatura"};
        ImageIcon icon1 = new ImageIcon("src/images/turtle32.png");
        String n = (String)JOptionPane.showInputDialog(null, "Seleccione una opcion de conversion",
                "Menu Conversor", JOptionPane.QUESTION_MESSAGE, icon1, conversores, conversores[0]);
        System.out.println(n);

        if(n == null) {
            JOptionPane.showMessageDialog(null,"Programa Terminado");
            System.exit(0);
        }

        // CONVERTIDOR DE MONEDA  *******************************************************************************
        if(n.equals(conversores[0])){
            ImageIcon iconCantidadDinero = new ImageIcon("src/images/turtle32.png");
            String n2 = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir");
            if(n2 == null){
                pantallaInicial();
            }

            Double cantidadInt;
            try {
                cantidadInt = Double.parseDouble(n2);

            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, String
                        .format("El campo cantidad debe ser numérico dentro del rango %d y %d.", 0, Integer.MAX_VALUE));
                pantallaInicial();
            }
            System.out.println(n2);
            String[] tipoCambio = {"De $COP a Dolar", "De $COP a Euro", "De $COP a Libras", "De $COP a Yen", "De $COP a Won Coreano",
                    "De Dolar a $COP", "De Euro a $COP", "De Libras a $COP", "De Yen a $COP", "De Won Coreano a $COP",
            };
            double[] tasaCambio = {0.00022, 0.00020, 0.00018, 0.029, 0.27, 4529.91,4921.89, 5608.48, 34.88, 3.68};
            ImageIcon iconTipoCambio = new ImageIcon("src/images/turtle32.png");
            String n3 = (String)JOptionPane.showInputDialog(null, "Seleccione una opcion de conversion",
                    "Menu Conversor", JOptionPane.QUESTION_MESSAGE, iconTipoCambio, tipoCambio, tipoCambio[0]);
            if(n3 == null) {
                JOptionPane.showMessageDialog(null,"Programa Terminado");
                System.exit(0);
            }
            Double comparacion = 0.0;
            for (int i=0; i < tipoCambio.length; i++) {
                if(n3.equals(tipoCambio[i])) {
                     comparacion = Double.parseDouble(n2);
                     comparacion = comparacion * tasaCambio[i];
                }
            }
            JOptionPane.showMessageDialog(null,"$" + comparacion);
            int n4 = JOptionPane.showConfirmDialog(null,"¿Desea Continuar usando el convertidor?", "Pregunta", JOptionPane.YES_NO_OPTION);
            System.out.println(n4);
            if(n4 == 0) {
                pantallaInicial();
            } else {
                JOptionPane.showMessageDialog(null,"Programa Terminado");
                System.exit(0);
            }


            // CONVERTIDOR DE TEMPS *******************************************************************************
        }  if(n.equals(conversores[1])){
            String n2 = JOptionPane.showInputDialog("Ingresa la temperatura que deseas convertir");
            if(n2 == null){
                pantallaInicial();
            }

            Double cantidadInt;
            try {
                cantidadInt = Double.parseDouble(n2);

            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, String
                        .format("El campo temperatura debe ser numérico dentro del rango %d y %d.", Integer.MIN_VALUE, Integer.MAX_VALUE));
                pantallaInicial();
            }
            System.out.println(n2);

            //1 °C + 273.15 = 274.15 K
            // (1 °C × 9/5) + 32 = 33.8 °F
            //1 K − 273.15 = -272.1 °C
            // (1 K − 273.15) × 9/5 + 32 = -457.9 °F
            // (1 °F − 32) × 5/9 = -17.22 °C
            //(1 °F − 32) × 5/9 + 273.15 = 255.928 K
            String[] tipoTemp = {"De Celsius a Kelvin", "De Celsius a Fahrenheit", "De Kelvin a Celsius", "De Kelvin a Fahrenheit",
                    "De Fahrenheit a Celsius", "De Fahrenheit a Kelvin"};
            ImageIcon iconTipoCambio = new ImageIcon("src/images/turtle32.png");
            String n3 = (String)JOptionPane.showInputDialog(null, "Seleccione una opcion de conversion",
                    "Menu Conversor", JOptionPane.QUESTION_MESSAGE, iconTipoCambio, tipoTemp, tipoTemp[0]);
            if(n3 == null) {
                JOptionPane.showMessageDialog(null,"Programa Terminado");
                System.exit(0);
            }
            Double comparacion = Double.parseDouble(n2);
            System.out.println(n3);
            if (n3.equals(tipoTemp[0])){
                comparacion = (comparacion) + 273.15;
            }

            if (n3.equals(tipoTemp[1])){
                comparacion = (comparacion*(1.8)) + 32;
            }
            if (n3.equals(tipoTemp[2])){
                comparacion = comparacion - 273.15;
            }
            if (n3.equals(tipoTemp[3])){
                comparacion = ((comparacion - 273.15) * (1.8)) + 32;
            }
            if (n3.equals(tipoTemp[4])){
                comparacion = (comparacion - 32) * (0.56);
            }
            if (n3.equals(tipoTemp[5])){
                comparacion = ((comparacion - 32) * (0.56)) + 273.15;
            }




            JOptionPane.showMessageDialog(null,"°" + comparacion);
            int n4 = JOptionPane.showConfirmDialog(null,"¿Desea Continuar usando el convertidor?", "Pregunta", JOptionPane.YES_NO_OPTION);
            System.out.println(n4);
            if(n4 == 0) {
                pantallaInicial();
            } else {
                JOptionPane.showMessageDialog(null,"Programa Terminado");
                System.exit(0);
            }
        }


    }
}