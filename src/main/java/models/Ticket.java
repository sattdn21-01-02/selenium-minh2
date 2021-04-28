package models;

public class Ticket {

    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private String ticketAmount;
    private String bookDate;
    private String expiredDate;
    private String status;
    private String totalPrice;

    public Ticket() {
    }

    public Ticket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        this.departDate = departDate;
        this.departFrom = departFrom;
        this.arriveAt = arriveAt;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }

    public Ticket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount, String bookDate, String expiredDate, String status, String totalPrice) {
        this.departDate = departDate;
        this.departFrom = departFrom;
        this.arriveAt = arriveAt;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
        this.bookDate = bookDate;
        this.expiredDate = expiredDate;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getArriveAt() {
        return arriveAt;
    }

    public void setArriveAt(String arriveAt) {
        this.arriveAt = arriveAt;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(String ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return this.getDepartDate()+
                " "+this.getDepartFrom()+
                " "+this.getArriveAt()+
                " "+this.getSeatType()+
                " "+this.getTicketAmount()+
                " "+this.getBookDate()+
                " "+this.getExpiredDate()+
                " "+this.getTotalPrice();
    }
}
