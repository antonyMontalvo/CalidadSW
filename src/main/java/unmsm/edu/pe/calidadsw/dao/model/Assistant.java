package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Assistant {
    private int _dni;
    private String _name;
    private String _lastname;
    private int _age;
    private String _telephone;
    private String _mail;
    private String _username;
    private String _password;

    public Assistant() {
    }

    public Assistant(int dni, String name, String lastname, int age, String telephone, String mail, String username,
            String password) {
        this._dni = dni;
        this._name = name;
        this._lastname = lastname;
        this._age = age;
        this._telephone = telephone;
        this._mail = mail;
        this._username = username;
        this._password = password;
    }

    public int getDni() {
        return _dni;
    }

    public void setDni(int dni) {
        this._dni = dni;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getLastname() {
        return _lastname;
    }

    public void setLastname(String lastname) {
        this._lastname = lastname;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int age) {
        this._age = age;
    }

    public String getTelephone() {
        return _telephone;
    }

    public void setTelephone(String telephone) {
        this._telephone = telephone;
    }

    public String getMail() {
        return _mail;
    }

    public void setMail(String mail) {
        this._mail = mail;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        this._password = password;
    }

}
