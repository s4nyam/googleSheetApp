package androidlabs.gsheets2.model;



/**
 * Created by sanyam on 10/1/2018.
 */
public class MyDataModel {

    private String formid;
    private String name;
    private String Pcontact;
    private String Pguardian;
    private String Paddress;
    private String Pdoj;
    private String gender;
    private String age;
    private String timestamp;
    private String dr_attending;
    private String bed_allot;
    private String insurance;
    private String ot_status;
    private String emergency_contact;


    public String getFormid() {
        return formid;
    }
    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return Pcontact;
    }
    public void setContact(String Pcontact) {
        this.Pcontact = Pcontact;
    }

    public String getGuardian() {
        return Pguardian;
    }
    public void setGuardian(String Pguardian) {
        this.Pguardian = Pguardian;
    }

    public String getAddress() {
        return Paddress;
    }
    public void setAddress(String Paddress) {
        this.Paddress = Paddress;
    }

    public String getDoj() {
        return Pdoj;
    }
    public void setDoj(String Pdoj) {
        this.Pdoj = Pdoj;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDr_attending() {
        return dr_attending;
    }
    public void setDr_attending(String dr_attending) {
        this.dr_attending = dr_attending;
    }

    public String getBed_allot() {
        return bed_allot;
    }
    public void setBed_allot(String bed_allot) {
        this.bed_allot = bed_allot;
    }

    public String getInsurance() {
        return insurance;
    }
    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getOt_status() {
        return ot_status;
    }
    public void setOt_status(String ot_status) {
        this.ot_status = ot_status;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }
    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }
}