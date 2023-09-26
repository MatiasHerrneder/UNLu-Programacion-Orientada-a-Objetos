import ar.edu.unlu.poo.tp2.ej12.Usuario;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cuenta y CuentaCredito no tienen similitudes como para que tenga sentido hacer herencia" +
                " (ni qiuiera en metodos abstractos), en cambio, si tiene sentido con Cuenta y CajaDeAhorro");


        Usuario u1 = new Usuario("Juan");
        u1.abrirCuentaNormal(100, 20);
        u1.abrirCuentaCredito(200);

        Usuario u2 = new Usuario("Monica");
        u2.abrirCajaDeAhorro(300);

        u1.getCuentaNormal().setPrecancelarInversionAutomaticamente(true);
        u1.getCuentaNormal().invertir(80, 40);
        u1.getCuentaNormal().gastar(90);
        System.out.println("Saldo de cuenta normal: " + u1.getCuentaNormal().getSaldo());

        u1.getCuentaCredito().comprar(100);
        u1.getCuentaCredito().pagar(50, 0);
        System.out.println("Saldo deudor cuenta credito: " + u1.getCuentaCredito().getSaldoDeudor());
        System.out.println("Monto disponible para compras: " + u1.getCuentaCredito().getMontoDisponibleParaCompras());

        System.out.println("Puedo hacer un pago de 310 con la caja de ahorro?: " + u2.getCajaDeAhorro().gastar(310));

        /*
            Cuenta y CuentaCredito no tienen similitudes como para que tenga sentido hacer herencia
            (ni qiuiera en metodos abstractos), en cambio, si tiene sentido con Cuenta y CajaDeAhorro
        */
    }
}