import ar.edu.unlu.poo.tp2.ej4.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente(123, "Pedro", 300);
        System.out.println("Saldo de la cuenta: " + c.getSaldo());
        System.out.println("Limite de giro en descubierto: " + c.getLimiteDeGiroEnDescubierto());
        System.out.println("Monto invertido: " + c.getMontoInvertido());
        System.out.println("Monto disponible en cuenta credito: " + c.getMontoCredito() + ", Saldo deudor: " + c.getSaldoDeudorCredito());

        System.out.println("--- Hago algunos movimientos y abro una cuenta credito para el cliente ---");

        c.abrirCuentaCredito(200);
        c.sumarSaldoDebito(1000);
        c.hacerCompraCredito(100);
        c.hacerInversion(350, 10);

        System.out.println("Saldo de la cuenta: " + c.getSaldo());
        System.out.println("Limite de giro en descubierto: " + c.getLimiteDeGiroEnDescubierto());
        System.out.println("Monto invertido: " + c.getMontoInvertido());
        System.out.println("Monto disponible en cuenta credito: " + c.getMontoCredito() + ", Saldo deudor: " + c.getSaldoDeudorCredito());
        System.out.println("Estado de restar 700 a debito: " + c.restarSaldoDebito(700));
    }
}