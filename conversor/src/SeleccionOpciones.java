
import javax.swing.JOptionPane;

public class SeleccionOpciones {
    public void eleccionOpciones() {
        ConversorMonedas metodoMonedas = new ConversorMonedas();
        Object[] options = {"Convesor de monedas"};
        String selectedOption = (String) JOptionPane.showInputDialog(null, "Escoge una opción", "Menu",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {
            if (selectedOption.equals(options[0])) {
                metodoMonedas.conversionMoneda();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes hacer una selección");
        }
    }

    public void continuar() {        
            int option = JOptionPane.showOptionDialog(
                null,
                "¿Desea seguir en el programa?",
                "Confirmar",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Sí", "No", "Cancelar"},
                "Sí");
        switch (option) {
            case JOptionPane.YES_OPTION:
                eleccionOpciones();
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "Terminar programa");
                break;
            case JOptionPane.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Terminar programa");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Terminar programa");
                break;
        }       
    }   
}
