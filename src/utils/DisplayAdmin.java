package utils;

import controller.RoomController;
import model.Appointment;
import model.Patient;
import view.AppointmentView;

import view.DoctorView;
import view.PatientView;

public class DisplayAdmin {

    public static void displayAdmin(){

        boolean running = true;
    
        while (running) {
            System.out.println("====================================");
            System.out.println("=         BY : Kelompok 2          =");
            System.out.println("====================================");
            System.out.println("====================================");
            System.out.println(" 0. Keluar                        ");
            System.out.println(" 1. Kelola Dokter                 ");
            System.out.println(" 2. Kelola Pasien                 ");
            System.out.println(" 3. Kelola Perawat                ");
            System.out.println(" 4. Kelola Resepsionis            ");
            System.out.println(" 5. Kelola Ruangan                ");
            System.out.println(" 6. Kelola Janji Temu             ");
            System.out.println("====================================");
            System.out.print("Pilih menu: ");
            int pilihan = Global.scanner.nextInt();
            Global.scanner.nextLine();
    
            switch (pilihan) {
                case 1:
                    displayAdminDokter();
                    break;
                case 2:
                    displayAdminPasien();
                    break;
                case 3:
                    displayAdminPerawat();
                    break;
                case 4:
                    displayAdminResepsionis();
                    break;
                case 5:
                    displayAdminRuangan();
                    break;
                case 6:
                    displayAdminJanjiTemu();
                    break;
                case 0:
                    running = false;
                    System.out.println("Keluar dari sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    
    public static void displayAdminDokter(){
        int choice  = 1;

        while(choice != 0){
            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Lihat Dokter");
            System.out.println("2. Tambah Dokter");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine(); 
            switch (choice) {
                case 0:
                    break;
                case 1:
                    displayAdminDetailDokter();
                    break;
                case 2:
                    Global.addDoctor();
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
        
    }

    public static void displayAdminPasien(){
        int choice  = 1;

        while(choice != 0){
            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Lihat Pasien");
            System.out.println("2. Tambah Pasien");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine(); 
            switch (choice) {
                case 0:
                    break;
                case 1:
                    displayAdminDetailDokter();
                    break;
                case 2:
                    Global.addPatient();
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }

    public static void displayAdminResepsionis(){
        int choice  = 1;
        while(choice != 0){

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Lihat Resepsionis");
            System.out.println("2. Tambah Resepsionis");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine(); 
            switch (choice) {
                case 0:
                    break;
                case 1:
                    displayAdminDetailResepsionis();
                    break;
                case 2:
                    Global.addReceptionist();
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }

    public static void displayAdminPerawat(){
        int choice  = 1;
        while(choice != 0){

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Lihat Perawat");
            System.out.println("2. Tambah Perawat");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine(); 
            switch (choice) {
                case 0:
                    break;
                case 1:
                    displayAdminDetailPerawat();
                    break;
                case 2:
                    Global.addNurse();
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }

    public static void displayAdminRuangan(){
        int choice  = 1;
        while(choice != 0){

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Lihat Ruangan");
            System.out.println("2. Tambah Ruangan");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine(); 
            switch (choice) {
                case 0:
                    break;
                case 1:
                    displayAdminDetailRuangan();
                    break;
                case 2:
                    Global.addRoom();
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }


    public static void displayAdminJanjiTemu(){
        int choice  = 1;
        while(choice != 0){

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Lihat Janji Temu Aktif");
            System.out.println("2. Lihat Janji Temu Pending");
            System.out.println("3. Tambahkan Janji Temu");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine(); 
            switch (choice) {
                case 0:
                    break;
                case 1:
                    displayAdminDetailJTAktif();;
                    break;
                case 2:
                    displayAdminDetailJTPending();
                    break;
                case 3: 
                    Global.scheduleAppointment();
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }


    public static void displayAdminDetailJTAktif(){
        int choice = 1;
        int index = 0;

        while(choice != 0){
            if(Global.activeAppointmentList.isEmpty()){
                System.out.println("Tidak ada janji temu yang belum disetujui");
                return;
            }
            System.out.println("====================================");
            Appointment currAp = Global.activeAppointmentList.get(index);
            AppointmentView.getDetail(currAp);
            AppointmentView.displayAgreementStatus(currAp);
            System.out.println("====================================");

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Selanjutnya");
            System.out.println("2. Sebelumnya");
            System.out.println("3. Batalkan Janji Temu");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine(); 


            switch (choice) {
                case 0:
                    break;
                case 1:
                    if(index < Global.activeAppointmentList.size() - 1){
                        index++;
                    }                    
                    break;
                case 2:
                    if(index > 0){
                        index--;
                    }
                    break;
                case 3: 
                    Global.activeAppointmentList.remove(index);
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }

    public static void displayAdminDetailJTPending(){
        int choice = 1;
        int index = 0;

        while(choice != 0){
            if(Global.pendingAppointmentList.isEmpty()){
                System.out.println("Tidak ada janji temu yang belum disetujui");
                return;
            }
            System.out.println("====================================");
            Appointment currAp = Global.pendingAppointmentList.get(index);
            AppointmentView.getDetail(currAp);
            AppointmentView.displayAgreementStatus(currAp);
            System.out.println("====================================");

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Selanjutnya");
            System.out.println("2. Sebelumnya");
            System.out.println("3. Batalkan Janji Temu");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine(); 


            switch (choice) {
                case 0:
                    break;
                case 1:
                    if(index < Global.pendingAppointmentList.size() - 1){
                        index++;
                    }                    
                    break;
                case 2:
                    if(index > 0){
                        index--;
                    }
                    break;
                case 3: 
                    Global.pendingAppointmentList.remove(index);
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }

    public static void displayAdminDetailDokter(){
        int choice  = 1;
        int index = 0;

        if(Global.doctorList.isEmpty()){
            System.out.println("Belum ada dokter yang didaftarkan");
            return;
        }

        while(choice != 0){
            System.out.println("====================================");
            System.out.println(Global.doctorList.get(index).getDetail());
            System.out.println("====================================");

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Selanjutnya");
            System.out.println("2. Sebelumnya");
            System.out.println("3. Edit Dokter");
            System.out.println("4. Assign dokter untuk pasien");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine(); 


            switch (choice) {
                case 0:
                    break;
                case 1:
                    if(index < Global.doctorList.size() - 1){
                        index++;
                    }                    
                    break;
                case 2:
                    if(index > 0){
                        index--;
                    }
                    break;
                case 3:
                    DoctorView.editDoctor(Global.doctorList.get(index));
                    break;
                case 4:
                    System.out.println("Masukkan Id / Nama Pasien");
                    String identifier = Global.scanner.nextLine();
                    Patient pasien = Global.searchPatient(identifier);
                    
                    if(pasien == null){
                        System.out.println("Data Pasien tidak ditemukan, Mohon ulangi operasi lagi");
                        return;
                    }
                    
                    Global.assignDoctor(Global.doctorList.get(index), pasien);
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }

    public static void displayAdminDetailPasien(){
        int choice  = 1;
        int index = 0;

        if(Global.patientList.isEmpty()){
            System.out.println("Belum ada pasien yang didaftarkan");
            return;
        }

        while(choice != 0){
            System.out.println("====================================");
            System.out.println(Global.patientList.get(index).getDetail());
            System.out.println("====================================");

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Selanjutnya");
            System.out.println("2. Sebelumnya");
            System.out.println("3. Edit pasien");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    if(index < Global.patientList.size() - 1){
                        index++;
                    }                    
                    break;
                case 2:
                    if(index > 0){
                        index--;
                    }
                    break;
                case 3:
                    PatientView.editPatient(Global.patientList.get(index));
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }


    public static void displayAdminDetailResepsionis(){
        int choice  = 1;
        int index = 0;

        if(Global.receptionistList.isEmpty()){
            System.out.println("Belum ada resepsionis yang didaftarkan");
            return;
        }

        while(choice != 0){
            System.out.println("====================================");
            System.out.println(Global.receptionistList.get(index).getDetail());
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
                    if(index < Global.receptionistList.size() - 1){
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

    public static void displayAdminDetailPerawat(){
        int choice  = 1;
        int index = 0;

        if(Global.nurseList.isEmpty()){
            System.out.println("Belum ada perawat yang didaftarkan");
            return;
        }

        while(choice != 0){
            System.out.println("====================================");
            System.out.println(Global.nurseList.get(index).getDetail());
            System.out.println("====================================");

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Selanjutnya");
            System.out.println("2. Sebelumnya");
            System.out.println("3. Assign perawat untuk pasien");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    if(index < Global.nurseList.size() - 1){
                        index++;
                    }                    
                    break;
                case 2:
                    if(index > 0){
                        index--;
                    }
                    break;
                case 3:
                    System.out.println("Masukkan Id / Nama Pasien");
                    String identifier = Global.scanner.nextLine();
                    Patient pasien = Global.searchPatient(identifier);
                    
                    if(pasien == null){
                        System.out.println("Data Pasien tidak ditemukan, Mohon ulangi operasi lagi");
                        return;
                    }
                    
                    Global.assignNurse(Global.nurseList.get(index), pasien);
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }

    public static void displayAdminDetailRuangan(){
        int choice  = 1;
        int index = 0;

        if(Global.roomList.isEmpty()){
            System.out.println("Belum ada pasien yang didaftarkan");
            return;
        }

        while(choice != 0){
            System.out.println("====================================");
            System.out.println(Global.roomList.get(index).getDetail());
            System.out.println("====================================");

            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Selanjutnya");
            System.out.println("2. Sebelumnya");
            System.out.println("3. Assign ruangan untuk pasien");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    if(index < Global.roomList.size() - 1){
                        index++;
                    }                    
                    break;
                case 2:
                    if(index > 0){
                        index--;
                    }
                    break;
                case 3:
                    System.out.println("Masukkan Id / Nama Pasien");
                    String identifier = Global.scanner.nextLine();
                    Patient pasien = Global.searchPatient(identifier);
                    
                    if(pasien == null){
                        System.out.println("Data Pasien tidak ditemukan, Mohon ulangi operasi lagi");
                        return;
                    }

                    RoomController.setForPatient(Global.roomList.get(index), pasien);
                    break;
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }

}
