package data;

import utils.Global;

public class Resepsionis extends Orang {

    public Resepsionis(String nama, int umur, String jenisKelamin, String alamat, String nomorKontak, String idKaryawan) {
        super(nama, umur, jenisKelamin, alamat, nomorKontak, idKaryawan);
    }

    public void jadwalkanJanjiTemu(Pasien pasien, Dokter dokter) {
        System.out.println("Resepsionis " + getNama() + " menjadwalkan janji temu antara pasien " + pasien.getNama() + " dengan dokter " + dokter.getNama());
    }


    public void displayResepsionis(){
        int choice = 1;
        while(choice != 0){
            System.out.println("====================================");
            System.out.println("0. Keluar");
            System.out.println("1. Lihat Profile");
            System.out.println("2. Jadwalkan Janji Temu");
            System.out.println("3. Assign dokter kepada pasien");
            System.out.println("====================================");
            choice = Global.scanner.nextInt();
            Global.scanner.nextLine();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    getDetail();
                    break;
                case 2:
                    displayJadwalkanJanjiTemu();
                    break;
                case 3: 
                    displayAssignPasien();
                    break;

            
                default:
                    System.out.println("Mohon pilih sesuai angka yang sudah disediakan");
                    break;
            }
        }
    }

    public void displayJadwalkanJanjiTemu(){
        System.out.println("Masukkan Id / Nama Dokter");
        String identifier = Global.scanner.nextLine();

        Dokter dokter = Global.searchDokter(identifier);

        if(dokter == null){
            System.out.println("Data Dokter tidak ditemukan, Mohon ulangi operasi lagi");
            return;
        }

        System.out.println("Masukkan Id / Nama Pasien");
        identifier = Global.scanner.nextLine();
        Pasien pasien = Global.searchPasien(identifier);


        if(pasien == null){
            System.out.println("Data Pasien tidak ditemukan, Mohon ulangi operasi lagi");
            return;
        }

        for(Ruangan ru : Global.daftarRuangan){
            if(ru.getIsTersedia().equals(true)){
                Global.jadwalkanJanjiTemu(dokter, pasien, ru, this);
                return;
            }
        }

        System.out.println("Tidak ada ruangan yang tersedia, Janji Temu tidak bisa dijadwalkan");

    }

    public void displayAssignPasien(){
        System.out.println("Masukkan Id / Nama Dokter");
        String identifier = Global.scanner.nextLine();

        Dokter dokter = Global.searchDokter(identifier);

        if(dokter == null){
            System.out.println("Data Dokter tidak ditemukan, Mohon ulangi operasi lagi");
            return;
        }

        System.out.println("Masukkan Id / Nama Pasien");
        identifier = Global.scanner.nextLine();
        Pasien pasien = Global.searchPasien(identifier);


        if(pasien == null){
            System.out.println("Data Pasien tidak ditemukan, Mohon ulangi operasi lagi");
            return;
        }

        dokter.getDetail();
        pasien.getDetail();

        Global.assignDokter(dokter, pasien);
    }

    //TODO: kayak diatas, tapi buat perawat.
    public void displayAssignPerawat(){
        System.out.println("Masukkan Id / Nama Perawat");
        String identifier = Global.scanner.nextLine();
        Perawat perawat = Global.searchPerawat(identifier);

        if(perawat == null){
            System.out.println("Data Perawat tidak ditemukan, Mohon ulangi operasi lagi");
            return;
        }

        System.out.println("Masukkan Id / Nama Pasien");
        identifier = Global.scanner.nextLine();
        Pasien pasien = Global.searchPasien(identifier);


        if(pasien == null){
            System.out.println("Data Pasien tidak ditemukan, Mohon ulangi operasi lagi");
            return;
        }

        perawat.getDetail();
        pasien.getDetail();

        Global.assignPerawat(perawat, pasien);
    }
}