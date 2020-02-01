public class VendingMachine {
    private Soda list[];
    private float credit;

    public VendingMachine() {
        list = new Soda[5];
        list[0] = new Soda("Coca Cola", 2.50f, 5);
        list[1] = new Soda("Fanta", 2.0f, 5);
        list[2] = new Soda("Sprite", 1.80f, 5);
        list[3] = new Soda("Grapette", 1.50f, 5);
        list[4] = new Soda("Jahuba", 1.30f, 5);
        this.credit = 0.0f;
    }

    public void insertCredit(float amount) {
        this.credit += amount;
    }

    public float requestChange() {
        float troco = this.credit;
        this.credit = 0.0f;
        return troco;
    }

    // retorna: 0-sucesso -1:sem crédito. -2:sem estoque
    public int buy(int numSoda) {
        if (this.credit >= list[numSoda].getPrice()) {
            if (list[numSoda].getAmount() > 0) {
                this.credit -= list[numSoda].getPrice();
                int newAmount = list[numSoda].getAmount() - 1;
                list[numSoda].setAmount(newAmount);
                return 0;
            } else {
                return -2;
            }
        } else {
            return -1;
        }
    }

    public String showInfo() {
        String str = "";
        str += "+==============================+\n" + "| Soda Machine.               |\n"
                + "+-----------------------------+\n" + "| Credit U$ : " + this.credit + "\n"
                + "+-----------------------------+\n";
        for (Soda s : list) {
            str += "|" + s.getName() + " U$ " + s.getPrice() + "\n";
        }

        str += "+===============================+\n";
        return str;

    }
}
