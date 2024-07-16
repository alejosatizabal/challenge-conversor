
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConversorMonedas {

    SeleccionOpciones menuDeOpciones = new SeleccionOpciones();
    monedas monedaDeCambio = new monedas();
    DecimalFormat formato = new DecimalFormat("#.00");

    public void mensaje(String monedaElegida, double valorObtenido, String monedaConvertida, double resultadoFinal) {
        String resultadoConvertido = formato.format(resultadoFinal);
        String mensajeFinal = "La cantidad de " + valorObtenido + " " + monedaElegida + " es igual a " + resultadoConvertido + " " + monedaConvertida;
        JOptionPane.showMessageDialog(null, mensajeFinal);        
        menuDeOpciones.continuar();
    }

    public void monedaToPesos(double moneda, String monedaElegida, double valorObtenido, String validarMoneda) {
        double totalConvertido = valorObtenido * moneda;
        monedaDeCambio.setMoneda("pesos", totalConvertido);
        monedaDeCambio.setMoneda(validarMoneda, valorObtenido);
        mensaje(monedaElegida, valorObtenido, "Pesos Colombianos", totalConvertido);
        
    }

    public void pesosToMoneda(double moneda, String monedaElegida, String validarMoneda) {
        monedaDeCambio.setMoneda("pesos", monedaDeCambio.getValorGeneral());
        double pesosColombianos = monedaDeCambio.getPesosCOP();
        double totalConvertido = pesosColombianos / moneda;
        monedaDeCambio.setMoneda(validarMoneda, totalConvertido);
        mensaje("Pesos Colombianos", pesosColombianos, monedaElegida, totalConvertido);
    }

    public void eleccionMoneda() {
        Object[] options = {"Pesos -> Dolar", "Pesos -> Euro",
            "Pesos -> Libras", "Pesos -> Yen", "Pesos -> Won Coreano",
            "Dolar -> Pesos", "Euro -> Pesos", "Libras -> Pesos",
            "Yen -> Pesos", "Coreano -> Pesos"};

        String selectedOption = (String) JOptionPane.showInputDialog(null, "Elije la moneda a convertir", "Monedas",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {
            switch (selectedOption) {
                case "Pesos -> Dolar":
                    pesosToMoneda(monedaDeCambio.getDolar(), "Dólares", "dolar");
                    break;
                case "Pesos -> Euro":
                    pesosToMoneda(monedaDeCambio.getEuro(), "Euros", "euro");
                    break;
                case "Pesos -> Libras":
                    pesosToMoneda(monedaDeCambio.getLibras(), "Libras", "libras");
                    break;
                case "Pesos -> Yen":
                    pesosToMoneda(monedaDeCambio.getYen(), "Yenes", "yen");
                    break;
                case "Pesos -> Won Coreano":
                    pesosToMoneda(monedaDeCambio.getWon_coreano(), "Wones", "won_coreano");
                    break;
                case "Dolar -> Pesos":
                    monedaToPesos(monedaDeCambio.getDolar(), "Dólares", monedaDeCambio.getValorGeneral(), "dolar");
                    break;
                case "Euro -> Pesos":
                    monedaToPesos(monedaDeCambio.getEuro(), "Euros", monedaDeCambio.getValorGeneral(), "euro");
                    break;
                case "Libras -> Pesos":
                    monedaToPesos(monedaDeCambio.getLibras(), "Libras", monedaDeCambio.getValorGeneral(), "libras");
                    break;
                case "Yen -> Pesos":
                    monedaToPesos(monedaDeCambio.getYen(), "Yenes", monedaDeCambio.getValorGeneral(), "yen");
                    break;
                case "Coreano -> Pesos":
                    monedaToPesos(monedaDeCambio.getWon_coreano(), "Wones", monedaDeCambio.getValorGeneral(), "won_coreano");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionaste ninguna opción");
        }
    }

    public void conversionMoneda() {
        JTextField textField = new JTextField();
        Object[] message = {
            "Digite la cantidad a convertir:", textField
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Conversión de moneda", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String valorRecibido = textField.getText();
            if (!valorRecibido.trim().isEmpty()) {
                try {
                    int valorDigitado = Integer.parseInt(valorRecibido);
                    if (valorDigitado > 0) {
                        monedaDeCambio.setValorGeneral(valorDigitado);
                        eleccionMoneda();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: la cantidad ingresada no es válida", "Error de ingreso",
                                JOptionPane.ERROR_MESSAGE);
                        conversionMoneda();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: el valor ingresado no es válido", "Error de ingreso",
                            JOptionPane.ERROR_MESSAGE);
                    conversionMoneda();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: Debes ingresar algún valor", "Error de ingreso",
                        JOptionPane.ERROR_MESSAGE);
                conversionMoneda();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saliste del programa", "Programa finalizado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
