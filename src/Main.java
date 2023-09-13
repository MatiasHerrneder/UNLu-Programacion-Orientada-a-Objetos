import ar.edu.unlu.poo.tp2.ej2.*;

public class Main {
    public static void main(String[] args) {
        ProveedorExcursion pex1 = new ProveedorExcursion("Empresa1", "10-1100111-1");
        pex1.agregarExcursion("Cabalgata");
        pex1.agregarExcursion("Tour por la ciudad");
        ProveedorExcursion pex2 = new ProveedorExcursion("Empresa2", "23-3322233-2");
        pex2.agregarExcursion("Subida al cerro");
        pex2.agregarExcursion("Esquiar");

        ProveedorMedioDeTransporte pmdt1 = new ProveedorMedioDeTransporte("Emp2", "67-677767-7");
        pmdt1.agregarMeidoDeTransporte("Colectivo");
        ProveedorMedioDeTransporte pmdt2 = new ProveedorMedioDeTransporte("Emp1", "45-454545-55");
        pmdt2.agregarMeidoDeTransporte("Avion");

        ProveedorHospedaje pho1 = new ProveedorHospedaje("e1", "89-8889999-8");
        pho1.agregarHospedaje("Hotel");
        ProveedorHospedaje pho2 = new ProveedorHospedaje("e2", "91-1999919-9");
        pho2.agregarHospedaje("Cabañas");

        Administrador adm = new Administrador();

        adm.agregarCliente(new Cliente("Carlos", 1234567));
        adm.agregarCliente(new Cliente("Marta", 2345678));
        adm.agregarDestino("Mar del Plata");
        adm.agregarDestino("Bariloche");
        adm.agregarProveedorExcursiones(pex1);
        adm.agregarProveedorExcursiones(pex2);
        adm.agregarProveedorMedioDeTransporte(pmdt1);
        adm.agregarProveedorMedioDeTransporte(pmdt2);
        adm.agregarProveedorHospedaje(pho1);
        adm.agregarProveedorHospedaje(pho2);
        adm.agregarPaquete(new Paquete(adm.getDestinos().get(0), adm.getProveedoresExcursiones().get(0).getExcursiones()
                            , adm.getProveedoresMediosDeTransporte().get(0), adm.getProveedoresHospedaje().get(0)));
        adm.agregarPaquete(new Paquete(adm.getDestinos().get(1), adm.getProveedoresExcursiones().get(1).getExcursiones()
                            , adm.getProveedoresMediosDeTransporte().get(1), adm.getProveedoresHospedaje().get(1)));

        adm.getClientes().get(0).contratarPaquete(adm.getPaquetes().get(0));
        adm.getClientes().get(0).contratarPaquete(adm.getPaquetes().get(1));
        adm.getClientes().get(1).contratarPaquete(adm.getPaquetes().get(1));

        System.out.println("--- Resumen de paquetes contratados ---");
        for (Paquete r : adm.resumenDeVentas()) {
            System.out.println(r.mostrarInformacion());
        }
        System.out.println("--- El destino favorito es: ---");
        System.out.println(adm.destinoFavorito());
    }
}