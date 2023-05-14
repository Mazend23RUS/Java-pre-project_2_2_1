package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
//    @MapsId
//    @OneToOne
//    @JoinColumn
    @OneToOne (mappedBy = "car")
    @PrimaryKeyJoinColumn
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String model;

    int series;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser(){
        return user;
    }


    public void setUser(User user){
        this.user = user;
    }

}
