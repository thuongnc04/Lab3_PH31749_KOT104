package com.ncthuong.lab3_ph31749

import java.util.Scanner

open class Nguoi(
    var hoTen: String,
    var tuoi: Int,
    var queQuan: String
)

class CBGV(
    hoTen: String,
    tuoi: Int,
    queQuan: String,
    var maSoGV: Int,
    var luongCung: Double,
    var luongThuong: Double,
    var tienPhat: Double
) : Nguoi(hoTen, tuoi, queQuan) {
    var luongThucLinh: Double = 0.0

    init {
        tinhLuongThucLinh()
    }

    fun tinhLuongThucLinh() {
        luongThucLinh = luongCung + luongThuong - tienPhat
    }
}

class QuanLyCBGV {
    private val danhSachCBGV: MutableList<CBGV> = mutableListOf()

    fun themCBGV(cbgv: CBGV) {
        danhSachCBGV.add(cbgv)
    }

    fun xoaCBGV(maSoGV: Int) {
        val cbgvToRemove = danhSachCBGV.find { it.maSoGV == maSoGV }
        cbgvToRemove?.let {
            danhSachCBGV.remove(it)
            println("Đã xóa cán bộ giáo viên có mã số $maSoGV")
        } ?: run {
            println("Không tìm thấy cán bộ giáo viên có mã số $maSoGV")
        }
    }

    fun hienThiDanhSachCBGV() {
        if (danhSachCBGV.isEmpty()) {
            println("Danh sách cán bộ giáo viên rỗng")
            return
        }
        danhSachCBGV.forEachIndexed { index, cbgv ->
            println("--------------------------------------")
            println("- Cán bộ giáo viên ${index + 1}:")
            println("Mã số: ${cbgv.maSoGV}")
            println("Họ tên: ${cbgv.hoTen}")
            println("Tuổi: ${cbgv.tuoi}")
            println("Quê quán: ${cbgv.queQuan}")
            println("Lương cứng: ${cbgv.luongCung}")
            println("Lương thưởng: ${cbgv.luongThuong}")
            println("Tiền phạt: ${cbgv.tienPhat}")
            println("Lương thực lĩnh: ${cbgv.luongThucLinh}")
            println()
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val quanLyCBGV = QuanLyCBGV()

    // Thêm dữ liệu cho các cán bộ giáo viên
    val cbgv1 = CBGV("Nguyễn Văn A", 35, "Hà Nội", 1, 5000.0, 1000.0, 200.0)
    val cbgv2 = CBGV("Trần Thị B", 40, "Hồ Chí Minh", 2, 5500.0, 1200.0, 250.0)
    val cbgv3 = CBGV("Lê Văn C", 30, "Đà Nẵng", 3, 4800.0, 900.0, 180.0)

    quanLyCBGV.themCBGV(cbgv1)
    quanLyCBGV.themCBGV(cbgv2)
    quanLyCBGV.themCBGV(cbgv3)

    while (true) {
        println("===== MENU =====")
        println("1. Thêm mới cán bộ giáo viên")
        println("2. Xóa cán bộ giáo viên theo mã số")
        println("3. Hiển thị danh sách cán bộ giáo viên")
        println("4. Thoát chương trình")
        print("Nhập lựa chọn của bạn: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Nhập họ tên: ")
                val hoTen = scanner.next()
                print("Nhập tuổi: ")
                val tuoi = scanner.nextInt()
                print("Nhập quê quán: ")
                val queQuan = scanner.next()
                print("Nhập mã số: ")
                val maSoGV = scanner.nextInt()
                print("Nhập lương cứng: ")
                val luongCung = scanner.nextDouble()
                print("Nhập lương thưởng: ")
                val luongThuong = scanner.nextDouble()
                print("Nhập tiền phạt: ")
                val tienPhat = scanner.nextDouble()

                val cbgv = CBGV(hoTen, tuoi, queQuan, maSoGV, luongCung, luongThuong, tienPhat)
                quanLyCBGV.themCBGV(cbgv)
                println("Đã thêm mới cán bộ giáo viên")
            }
            2 -> {
                print("Nhập mã số của cán bộ giáo viên cần xóa: ")
                val maSoGV = scanner.nextInt()
                quanLyCBGV.xoaCBGV(maSoGV)
            }
            3 -> {
                quanLyCBGV.hienThiDanhSachCBGV()
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
