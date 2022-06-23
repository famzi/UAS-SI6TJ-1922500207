<?php
    include "koneksi.php";
    $Nidn = $_POST['nidn'];
    $Nama_dosen = $_POST['nama_dosen'];
    $Jabatan = $_POST['jabatan'];
    $Gol_pang = $_POST['gol_pang'];
    $Keahlian = $_POST['keahlian'];
    $Program_studi = $_POST['program_studi'];

    $sql = mysqli_query($con, "INSERT INTO lecturer (nidn, nama_dosen, jabatan, gol_pang, keahlian, program_studi) VALUES
    ('$Nidn', '$Nama_dosen', '$Jabatan', '$Gol_pang', '$Keahlian', '$Program_studi')");

    if($sql) {
        echo json_encode($sql);
    }
?>