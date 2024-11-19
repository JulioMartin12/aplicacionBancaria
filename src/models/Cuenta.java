package models;

public class Cuenta {

    private Double saldo;

    public Cuenta(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public boolean retirar(Double monto){
        if(monto > this.getSaldo()){
            return false;
        }else{
            this.setSaldo(this.getSaldo() - monto);
            return true;
        }
    }

    public Double depositar(Double monto){
        this.setSaldo(this.getSaldo() + monto);
        return  this.getSaldo();
    }


}
