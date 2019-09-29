package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Assistant {
    private int dni;
    private String name;
    private String lastname;
    private int age;
    private String telephone;
    private String mail;
    private String username;
    private String password;

    public Assistant() {
    }

    public Assistant(int dni, String name, String lastname, int age, String telephone, String mail, String username,
            String password) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.telephone = telephone;
        this.mail = mail;
        this.username = username;
        this.password = password;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
