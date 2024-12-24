package view; 



import java.util.List;

import controller.PatientController;
import model.Patient;
import model.Appointment;
import utils.Global;


public class PatientView{
    public static void patientDisplay(Patient p){
        int choice = 1;
        while(choice != 0){
            System.out.println("====================================");
            System.out.println("=         BY : Kelompok 2          =");
            System.out.println("====================================");
            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Lihat Profile");
            System.out.println("2. Lihat Jadwal Janji Temu Aktif");
            System.out.println("3. Lihat Jadwal Janji Temu Pending");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine();


            switch (choice) {
                case 0:
                    break;
                case 1:
                    profileDisplay(p);
                    break;
                case 2:
                    listActiveAppointment(p);
                    break;
                case 3: 
                    listPendingAppointment(p);
                    break;
            
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }

    public static void profileDisplay(Patient p){
        int choice = 1;
        while(choice != 0){
            System.out.println("====================================");
            System.out.println(p.getDetail());
            System.out.println("====================================");
            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Edit Profil");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine();


            switch (choice) {
                case 0:
                    break;
                case 1:
                    editPatient(p);
                    break;
    
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }


    public static void listActiveAppointment(Patient p){
        int choice = 1;
        int index = 0;

        List<Appointment> listActiveAppointment = Global.getFilteredActiveAppointments(p.getId());


        if(listActiveAppointment.isEmpty()){
            System.out.println("Anda tidak mempunyai janji temu yang sedang aktif");
            return;
        }


        while(choice != 0){
            System.out.println("====================================");
            Appointment currAp = listActiveAppointment.get(index);
            AppointmentView.getDetail(currAp);
            System.out.println(currAp.getAgreementStatus());
            System.out.println("====================================");

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Selanjutnya");
            System.out.println("2. Sebelumnya");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine(); 


            switch (choice) {
                case 0:
                    break;
                case 1:
                    if(index < listActiveAppointment.size() - 1){
                        index++;
                    }                    
                    break;
                case 2:
                    if(index > 0){
                        index--;
                    }
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }


    public static void listPendingAppointment(Patient p){

        int choice = 1;
        int index = 0;

        List<Appointment> listPendingAppointment = Global.getFilteredPendingAppointments(p.getId());

        if(listPendingAppointment.isEmpty()){
            System.out.println("Tidak ada janji temu yang belum disetujui");
            return;
        }

        while(choice != 0){
            System.out.println("====================================");
            Appointment currAp = listPendingAppointment.get(index);
            AppointmentView.getDetail(currAp);
            System.out.println(currAp.getAgreementStatus());
            System.out.println("====================================");

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Selanjutnya");
            System.out.println("2. Sebelumnya");
            System.out.println("3. Setujui Janji Temu");
            System.out.println("4. Tolak Janji Temu");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine(); 


            switch (choice) {
                case 0:
                    break;
                case 1:
                    if(index < listPendingAppointment.size() - 1){
                        index++;
                    }                    
                    break;
                case 2:
                    if(index > 0){
                        index--;
                    }
                    break;
                case 3: 
                    currAp.setPatientAgreement(true);
                    break;
                case 4: 
                    currAp.setPatientAgreement(false);
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }


    public static void editPatient(Patient p){
        int choice = 1;
        while (choice != 0){
            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Edit Nama");
            System.out.println("2. Edit Umur");
            System.out.println("3. Edit Jenis Kelamin");
            System.out.println("4. Edit Alamat");
            System.out.println("5. Edit Nomor Kontak");
            System.out.println("6. Edit Riwayat Kesehatan");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine();
            
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println(PatientController.editPatientName(p));
                    break;
                case 2:
                    System.out.println(PatientController.editPatientAge(p));
                break;
                case 3:
                    System.out.println(PatientController.editPatientGender(p));
                break;
                case 4:
                    System.out.println(PatientController.editPatientAddress(p));
                break;
                case 5:
                    System.out.println(PatientController.editPatientContact(p));
                    break;

                case 6: 
                    System.out.println(PatientController.editPatientMedicalHistory(p));
                    break;

                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }

    public static void editPatientConditionDisplay(Patient p){
        System.out.println("Keadaan Pasien saat ini: " + p.getCurrentCondition());
        System.out.println(PatientController.editPatientCurrentCondition(p));
    }

}