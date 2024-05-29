package firemint.local;

public class Hand {
    double bet;
    double rWinnings;
    double bankroll;

    
    public Hand(double bet, double rWinnings, double bankroll) {
        this.setBet(bet);
        this.setrWinnings(rWinnings);
        this.setBankroll(bankroll);
    }
    
    public double getBet() {
        return bet;
    }
    public void setBet(double bet) {
        this.bet = bet;
    }
    public double getrWinnings() {
        return rWinnings;
    }
    public void setrWinnings(double rWinnings) {
        this.rWinnings = rWinnings;
    }
    public double getBankroll() {
        return bankroll;
    }

    public void setBankroll(double bankroll) {
        this.bankroll = bankroll;
    }
}
