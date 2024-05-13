package com.ncthuong.lab3_ph31749

import java.util.Scanner


// Lớp SinhVien để quản lý thông tin của mỗi sinh viên
class SinhVien(
    var hoTen: String,
    var tuoi: Int,
    var lop: String
)

// Lớp TheMuon để quản lý việc mượn trả sách của các sinh viên
class TheMuon(
    var maPhieuMuon: Int,
    var ngayMuon: Int,
    var hanTra: Int,
    var soHieuSach: String,
    var sinhVien: SinhVien
)

// Lớp QuanLyTheMuon để quản lý việc thêm, xoá theo mã phiếu mượn và hiển thị thông tin các thẻ mượn
class QuanLyTheMuon {
    private val danhSachTheMuon: MutableList<TheMuon> = mutableListOf()

    // Phương thức thêm một thẻ mượn sách
    fun themTheMuon(theMuon: TheMuon) {
        danhSachTheMuon.add(theMuon)
    }

    // Phương thức xoá một thẻ mượn sách dựa trên mã phiếu mượn
    fun xoaTheMuon(maPhieuMuon: Int) {
        val theMuonToRemove = danhSachTheMuon.find { it.maPhieuMuon == maPhieuMuon }
        theMuonToRemove?.let {
            danhSachTheMuon.remove(it)
            println("Đã xoá thẻ mượn sách có mã phiếu mượn $maPhieuMuon")
        } ?: run {
            println("Không tìm thấy thẻ mượn sách có mã phiếu mượn $maPhieuMuon")
        }
    }

    // Phương thức hiển thị thông tin các thẻ mượn sách
    fun hienThiDanhSachTheMuon() {
        if (danhSachTheMuon.isEmpty()) {
            println("Danh sách thẻ mượn sách rỗng")
            return
        }
        danhSachTheMuon.forEachIndexed { index, theMuon ->
            println("--------------------------------------")
            println("Thẻ mượn sách ${index + 1}:")
            println("Mã phiếu mượn: ${theMuon.maPhieuMuon}")
            println("Ngày mượn: ${theMuon.ngayMuon}")
            println("Hạn trả: ${theMuon.hanTra}")
            println("Số hiệu sách: ${theMuon.soHieuSach}")
            println("Thông tin sinh viên:")
            println("- Họ tên: ${theMuon.sinhVien.hoTen}")
            println("- Tuổi: ${theMuon.sinhVien.tuoi}")
            println("- Lớp: ${theMuon.sinhVien.lop}")
            println()
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val quanLyTheMuon = QuanLyTheMuon()

    // Thêm dữ liệu mẫu
    val sinhVien1 = SinhVien("Nguyễn Văn A", 20, "KTPM1")
    val theMuon1 = TheMuon(1, 1, 10, "SH001", sinhVien1)

    val sinhVien2 = SinhVien("Trần Thị B", 21, "KTPM2")
    val theMuon2 = TheMuon(2, 2, 11, "SH002", sinhVien2)

    val sinhVien3 = SinhVien("Lê Văn C", 22, "KTPM3")
    val theMuon3 = TheMuon(3, 3, 12, "SH003", sinhVien3)

    quanLyTheMuon.themTheMuon(theMuon1)
    quanLyTheMuon.themTheMuon(theMuon2)
    quanLyTheMuon.themTheMuon(theMuon3)

    while (true) {
        println("===== MENU =====")
        println("1. Thêm thẻ mượn sách")
        println("2. Xoá thẻ mượn sách theo mã phiếu mượn")
        println("3. Hiển thị thông tin các thẻ mượn sách")
        println("4. Thoát chương trình")
        print("Nhập lựa chọn của bạn: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Nhập mã phiếu mượn: ")
                val maPhieuMuon = scanner.nextInt()
                print("Nhập ngày mượn: ")
                val ngayMuon = scanner.nextInt()
                print("Nhập hạn trả: ")
                val hanTra = scanner.nextInt()
                print("Nhập số hiệu sách: ")
                val soHieuSach = scanner.next()
                print("Nhập thông tin sinh viên: \n")
                print(" - Họ tên: ")
                val hoTen = scanner.next()
                print(" - Tuổi: ")
                val tuoi = scanner.nextInt()
                print(" - Lớp: ")
                val lop = scanner.next()

                val sinhVien = SinhVien(hoTen, tuoi, lop)
                val theMuon = TheMuon(maPhieuMuon, ngayMuon, hanTra, soHieuSach, sinhVien)
                quanLyTheMuon.themTheMuon(theMuon)
                println("Đã thêm mới thẻ mượn sách")
            }
            2 -> {
                print("Nhập mã phiếu mượn của thẻ cần xoá: ")
                val maPhieuMuon = scanner.nextInt()
                quanLyTheMuon.xoaTheMuon(maPhieuMuon)
            }
            3 -> {
                quanLyTheMuon.hienThiDanhSachTheMuon()
            }
            4 -> {
                println("Đã thoát chương trình.")
                return
            }
            else -> {
                println("Lựa chọn không hợp lệ, vui lòng chọn lại.")
            }
        }
    }
}
