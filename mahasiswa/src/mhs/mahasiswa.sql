-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Jun 2024 pada 16.38
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mahasiswa`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mhs`
--

CREATE TABLE `mhs` (
  `id_mhs` int(11) NOT NULL,
  `nim` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `nilai_uts` double NOT NULL,
  `nilai_uas` double NOT NULL,
  `nilai_tugas` double NOT NULL,
  `nilai_akhir` double NOT NULL,
  `nilai_huruf` char(2) NOT NULL,
  `predikat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `mhs`
--

INSERT INTO `mhs` (`id_mhs`, `nim`, `nama`, `nilai_uts`, `nilai_uas`, `nilai_tugas`, `nilai_akhir`, `nilai_huruf`, `predikat`) VALUES
(3, '1398', 'Nisa', 95, 95, 100, 96.66666666666667, 'A', 'Sangat Baik'),
(5, '14272', 'ramadhan', 91, 95, 100, 95.33333333333333, 'A', 'Sangat Baik'),
(6, '13981', 'Galuh', 90, 85, 75, 83.33333333333333, 'A', 'Sangat Baik'),
(7, '14275', 'Rani', 75, 60, 79, 70.95, 'B', 'Baik');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mhs`
--
ALTER TABLE `mhs`
  ADD PRIMARY KEY (`id_mhs`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `mhs`
--
ALTER TABLE `mhs`
  MODIFY `id_mhs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
