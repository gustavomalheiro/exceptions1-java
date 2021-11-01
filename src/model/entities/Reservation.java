package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    // colocando esse objeto como estatico para que nao seja instanciado um novo
    // simple date format para cada objeto reservation
    // que a minha aplicação tiver
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    // tipo long = inteiro mais longo
    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime(); // getTime me devolve a quantidade de milisegundos daquela
                                                            // data
        // agora preciso converter milissegundos para dias, utilizando esse tipo
        // enumerado complexo chamado timeUnit
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    // esse método que vai ser responsável por atualizar as datas, então por isso
    // que eu apaguei o setCheckIn e o setCheckOut
    public void updateDates(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // o toString também é uma sobreposição. Então agora sempre vamos colocar o
    // Override em cima dele.
    @Override
    public String toString() {
        return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
                + ", " + duration() + " nights";
    }
}
