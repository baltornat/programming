import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class erogaServizio extends Thread{
    private Socket toClient;

    public erogaServizio(Socket socket){
        this.toClient = socket;
    }

    public void run(){
        int dim = 100;
        byte buf[] = new byte[dim];
        int letti;
        double n1 = 1, n2 = 1, risultato = 0;
        String output, operando;

        try{
            InputStream is = toClient.getInputStream();
            while(true){
                //Leggo operando
                letti = is.read(buf);
                operando = new String(buf, 0, letti);
                System.out.println(operando);
                if(operando.equals("+") || operando.equals("-") || operando.equals("*") || operando.equals("/")){
                    OutputStream os = toClient.getOutputStream();
                    os.write("Perfetto!".getBytes(), 0, "Perfetto!".length());
                    //Leggo primo numero
                    letti = is.read(buf);
                    output = new String(buf, 0, letti);
                    System.out.println(output);
                    try{
                        n1 = Double.parseDouble(output);
                        os.write("Valore 1 ammesso!".getBytes(), 0, "Valore 1 ammesso!".length());
                    }catch(NumberFormatException nfe){
                        System.out.println("Non è un numero!");
                        os.write("Inserisci un numero!".getBytes(), 0, "Inserisci un numero!".length());
                    }
                    //Leggo secondo numero
                    letti = is.read(buf);
                    output = new String(buf, 0, letti);
                    try{
                        n2 = Double.parseDouble(output);
                        os.write("Valore 2 ammesso!".getBytes(), 0, "Valore 2 ammesso!".length());
                    }catch(NumberFormatException nfe){
                        System.out.println("Non è un numero!");
                        os.write("Inserisci un numero!".getBytes(), 0, "Inserisci un numero!".length());
                    }
                    //Applico operazione
                    switch(operando){
                        case "+": risultato = n1 + n2;
                            break;
                        case "-": risultato = n1 - n2;
                            break;
                        case "*": risultato = n1 * n2;
                            break;
                        case "/": risultato = n1 / n2;
                            break;
                        default: System.out.println("Errore!");
                    }
                    //Stampa risultato
                    output = "Risultato: " + Double.toString(risultato);
                    os.write(output.getBytes(), 0, output.length());
                    //Nuovi conti?
                    letti = is.read(buf);
                    output = new String(buf, 0, letti);
                    if(output.equals(".")){
                        toClient.close();
                        break;
                    }
                }else{
                    OutputStream os = toClient.getOutputStream();
                    os = toClient.getOutputStream();
                    os.write("Sbagliato!".getBytes(), 0, "Sbagliato!".length());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
