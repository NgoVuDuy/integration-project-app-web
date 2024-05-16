-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th5 16, 2024 lúc 10:39 AM
-- Phiên bản máy phục vụ: 10.5.20-MariaDB
-- Phiên bản PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `id21901405_dienthoai`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `idgiohang` int(11) NOT NULL,
  `idnguoidat` varchar(255) NOT NULL,
  `tensp` varchar(255) NOT NULL,
  `giasp` varchar(255) NOT NULL,
  `soluong` varchar(255) NOT NULL,
  `mausac` varchar(255) NOT NULL,
  `bonho` varchar(255) NOT NULL,
  `tongtien` varchar(255) NOT NULL,
  `linksp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cart`
--

INSERT INTO `cart` (`idgiohang`, `idnguoidat`, `tensp`, `giasp`, `soluong`, `mausac`, `bonho`, `tongtien`, `linksp`) VALUES
(137, '6', 'Điện thoại iPhone 15 Pro Max', '31.690.001', '1', 'Titan đen\r\n\r\n', '256GB', '31.690.001', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-pro-max-black.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdon`
--

CREATE TABLE `chitietdon` (
  `idchitietdon` int(11) NOT NULL,
  `iddon` varchar(255) NOT NULL,
  `iddienthoai` varchar(255) NOT NULL,
  `ten` varchar(255) NOT NULL,
  `soluong` varchar(255) NOT NULL,
  `mausac` varchar(255) NOT NULL,
  `bonho` varchar(255) NOT NULL,
  `linkanh` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdon`
--

INSERT INTO `chitietdon` (`idchitietdon`, `iddon`, `iddienthoai`, `ten`, `soluong`, `mausac`, `bonho`, `linkanh`) VALUES
(8, '27', '48', 'REDMI NOTE 13 PRO', '1', 'Đen', '7.290.000', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Black-600x600.png'),
(9, '27', '49', 'Realme C55', '1', 'Vàng', '4.990.000', 'https://dpna.000webhostapp.com/api/img/realme/realme-c35-vang-thumb-600x600.jpg'),
(10, '28', '51', 'Điện thoại iPhone 15 Pro Max', '1', 'Titan Đen', '31.690.000', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-pro-max-black.jpg'),
(11, '28', '52', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '22.990.000', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(12, '29', '53', 'REDMI NOTE 13 PRO', '1', 'Đen', '7.290.000', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Black-600x600.png'),
(13, '29', '54', 'Realme C55', '1', 'Vàng', '4.990.000', 'https://dpna.000webhostapp.com/api/img/realme/realme-c35-vang-thumb-600x600.jpg'),
(14, '29', '55', 'OPPO Reno10 5G', '1', 'Xanh', '8.690.000', 'https://dpna.000webhostapp.com/api/img/oppo/oppo-reno10-blue-thumbnew-600x600.jpg'),
(15, '30', '56', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '22.990.000', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(16, '30', '57', 'REDMI NOTE 13 PRO', '1', 'Đen', '7.290.000', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Black-600x600.png'),
(17, '30', '58', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '22.990.000', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(18, '30', '59', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '22.990.000', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(19, '31', '7', 'OPPO Reno10 5G', '1', 'Xanh', '128G', 'https://dpna.000webhostapp.com/api/img/oppo/oppo-reno10-blue-thumbnew-600x600.jpg'),
(20, '32', '2', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Tím', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-purple.jpg'),
(21, '33', '2', 'Điện thoại Samsung Galaxy S24 5G', '2', 'Tím', '512G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-purple.jpg'),
(22, '34', '60', 'REDMI NOTE 13 PRO', '2', 'Đen', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Black-600x600.png'),
(23, '34', '61', 'Realme C55', '2', 'Vàng', '6G-128G', 'https://dpna.000webhostapp.com/api/img/realme/realme-c35-vang-thumb-600x600.jpg'),
(24, '35', '2', 'Điện thoại Samsung Galaxy S24 5G', '2', 'Tím', '512G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-purple.jpg'),
(25, '36', '74', 'OPPO Reno10 5G', '1', 'Xanh', '128G', 'https://dpna.000webhostapp.com/api/img/oppo/oppo-reno10-blue-thumbnew-600x600.jpg'),
(26, '37', '2', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Tím', '512G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-purple.jpg'),
(27, '38', '5', 'Realme 11', '3', 'Vàng', '128G', 'https://dpna.000webhostapp.com/api/img/realme/realme-11-vang-thumb-200x200.jpg'),
(28, '39', '2', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Tím', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-purple.jpg'),
(29, '40', '1', 'Điện thoại iPhone 15 Pro Max', '1', 'Titan hồng', '1T', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-hong.jpg'),
(30, '41', '2', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Xám', '512G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-grey.jpg'),
(31, '42', '3', 'REDMI NOTE 13 PRO', '1', 'Đen', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/xiaomi-redmi-note-13-pro-plus-black-thumb-200x200.jpg'),
(32, '43', '6', 'Oppo A57', '2', 'Vàng', '128G', 'https://dpna.000webhostapp.com/api/img/oppo/oppo-a57-vang-thumb-600x600.jpg'),
(33, '44', '77', 'REDMI NOTE 13 PRO', '1', 'Đen', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Black-600x600.png'),
(34, '44', '78', 'Realme C55', '1', 'Vàng', '6G-128G', 'https://dpna.000webhostapp.com/api/img/realme/realme-c35-vang-thumb-600x600.jpg'),
(35, '45', '9', 'realme Note 50 ', '2', 'Xanh', '64G', 'https://dpna.000webhostapp.com/api/img/realme/realme-note-50-blue-thumb-600x600.jpg'),
(36, '46', '2', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Xám', '512G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-grey.jpg'),
(37, '47', '4', 'Realme C55', '1', 'Đen', '8G-256G', 'https://dpna.000webhostapp.com/api/img/realme/realme-c35-den-thumb-200x200.jpg'),
(38, '48', '6', 'Oppo A57', '1', 'Xanh', '128G', 'https://dpna.000webhostapp.com/api/img/oppo/oppo-a57-xanh-thumb-1-200x200.jpeg'),
(39, '49', '3', 'REDMI NOTE 13 PRO', '1', 'Tím', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Purple-600x600.png'),
(40, '50', '123', 'REDMI NOTE 13 PRO', '1', 'Tím', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Purple-600x600.png'),
(41, '51', '123', 'REDMI NOTE 13 PRO', '1', 'Tím', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Purple-600x600.png'),
(42, '52', '123', 'REDMI NOTE 13 PRO', '1', 'Tím', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Purple-600x600.png'),
(43, '53', '122', 'REDMI NOTE 13 PRO', '1', 'Tím', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Purple-600x600.png'),
(44, '53', '123', 'REDMI NOTE 13 PRO', '1', 'Tím', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Purple-600x600.png'),
(45, '54', '122', 'REDMI NOTE 13 PRO', '1', 'Tím', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Purple-600x600.png'),
(46, '54', '123', 'REDMI NOTE 13 PRO', '1', 'Tím', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Purple-600x600.png'),
(47, '55', '1', 'Điện thoại iPhone 15 Pro Max', '1', 'Titan đen\r\n\r\n', '512GB', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-pro-max-black.jpg'),
(48, '56', '124', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(49, '56', '125', 'REDMI NOTE 13 PRO', '1', 'Đen', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Black-600x600.png'),
(50, '57', '124', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(51, '57', '125', 'REDMI NOTE 13 PRO', '1', 'Đen', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Black-600x600.png'),
(52, '58', '124', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(53, '58', '125', 'REDMI NOTE 13 PRO', '1', 'Đen', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Black-600x600.png'),
(54, '59', '124', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(55, '59', '125', 'REDMI NOTE 13 PRO', '1', 'Đen', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Black-600x600.png'),
(56, '60', '126', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(57, '60', '127', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(58, '60', '128', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(59, '61', '1', 'Điện thoại iPhone 15 Pro Max', '1', 'Titan xanh lá', '512GB', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-xanh-la.jpg'),
(60, '62', '126', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(61, '62', '127', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(62, '62', '128', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(63, '62', '129', 'Điện thoại iPhone 15 Pro Max', '1', 'Titan xanh lá', '512GB', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-xanh-la.jpg'),
(64, '62', '130', 'Điện thoại iPhone 15 Pro Max', '1', 'Titan xanh lá', '512GB', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-xanh-la.jpg'),
(65, '63', '131', 'Điện thoại Samsung Galaxy S24 5G', '1', 'Vàng', '512G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(66, '64', '132', 'Điện thoại iPhone 15 Pro Max', '1', 'Titan hồng', '1T', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-hong.jpg'),
(67, '65', '1', 'Điện thoại iPhone 15 Pro Max', '1', 'Titan xanh lá', '256GB', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-xanh-la.jpg'),
(68, '66', '7', 'OPPO Reno10 5G', '1', 'Xanh', '256G', 'https://dpna.000webhostapp.com/api/img/oppo/oppo-reno10-blue-thumbnew-600x600.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `color`
--

CREATE TABLE `color` (
  `idmausac` int(255) NOT NULL,
  `iddienthoai` int(11) NOT NULL,
  `mausac` varchar(255) NOT NULL,
  `linkmausac` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `color`
--

INSERT INTO `color` (`idmausac`, `iddienthoai`, `mausac`, `linkmausac`) VALUES
(1, 1, 'Titan đen\r\n\r\n', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-pro-max-black.jpg'),
(2, 1, 'Titan hồng', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-hong.jpg'),
(3, 1, 'Titan xanh biển\r\n\r\n', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-pro-blue.jpg'),
(4, 1, 'Titan xanh lá', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-xanh-la.jpg'),
(5, 2, 'Vàng', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(6, 2, 'Xám', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-grey.jpg'),
(7, 2, 'Đen', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-black.jpg'),
(8, 2, 'Tím', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-purple.jpg'),
(9, 3, 'Đen', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Black-600x600.png'),
(10, 3, 'Xanh lá', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Green-600x600.png'),
(11, 3, 'Tím', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Purple-600x600.png'),
(12, 4, 'Vàng', 'https://dpna.000webhostapp.com/api/img/realme/realme-c35-vang-thumb-600x600.jpg'),
(13, 4, 'Đen', 'https://dpna.000webhostapp.com/api/img/realme/realme-c35-den-thumb-200x200.jpg'),
(14, 5, 'Đen', 'https://dpna.000webhostapp.com/api/img/realme/realme-11-thumb-600x600.jpg'),
(15, 5, 'Vàng', 'https://dpna.000webhostapp.com/api/img/realme/realme-11-vang-thumb-200x200.jpg'),
(16, 6, 'Vàng', 'https://dpna.000webhostapp.com/api/img/oppo/oppo-a57-vang-thumb-600x600.jpg'),
(17, 6, 'Xanh', 'https://dpna.000webhostapp.com/api/img/oppo/oppo-a57-xanh-thumb-1-200x200.jpeg'),
(18, 7, 'Xanh', 'https://dpna.000webhostapp.com/api/img/oppo/oppo-reno10-blue-thumbnew-600x600.jpg'),
(19, 8, 'Tím', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s23-fe-5g-tim-thumb-600x600.jpeg'),
(20, 8, 'Đen', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s23-fe-5g-den-thumb-200x200.jpeg'),
(21, 9, 'Xanh', 'https://dpna.000webhostapp.com/api/img/realme/realme-note-50-blue-thumb-600x600.jpg'),
(22, 9, 'Đen', 'https://dpna.000webhostapp.com/api/img/realme/realme-note-50-black-thumb-200x200.jpg'),
(23, 10, 'Trắng', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-11-trang-600x600.jpg'),
(24, 10, 'Đen', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-xi-den-200x200.jpg'),
(25, 11, 'Trắng', 'https://dpna.000webhostapp.com/api/img/xiaomi/xiaomi-redmi-note-13-pro-plus-white-thumb-600x600.jpg'),
(26, 11, 'Tím', 'https://dpna.000webhostapp.com/api/img/xiaomi/xiaomi-redmi-note-13-pro-plus-violet-thumb-200x200.jpg'),
(27, 3, 'Đen', 'https://dpna.000webhostapp.com/api/img/xiaomi/xiaomi-redmi-note-13-pro-plus-black-thumb-200x200.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dondat`
--

CREATE TABLE `dondat` (
  `iddon` int(11) NOT NULL,
  `idnguoidat` varchar(255) NOT NULL,
  `tamtinh` varchar(255) NOT NULL,
  `phivanchuyen` varchar(255) NOT NULL,
  `tongtien` varchar(255) NOT NULL,
  `trangthai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `dondat`
--

INSERT INTO `dondat` (`iddon`, `idnguoidat`, `tamtinh`, `phivanchuyen`, `tongtien`, `trangthai`) VALUES
(43, '6', '7.780.000', '0', '7.780.000', 'Đã nhận hàng'),
(44, '4', '12.280.000', '0', '12.280.000', 'Đã nhận hàng'),
(45, '4', '4.980.000', '0', '4.980.000', 'Đã nhận hàng'),
(46, '4', '22.990.000', '0', '22.990.000', 'Đang vận chuyển'),
(47, '4', '4.990.000', '0', '4.990.000', 'Đã nhận hàng'),
(48, '4', '3.890.000', '0', '3.890.000', 'Đang xử lý'),
(49, '4', '7.290.000', '0', '7.290.000', 'Đã nhận hàng'),
(55, '4', '31.690.000', '0', '31.690.000', 'Đang xử lý'),
(57, '4', '30.280.000', '0', '30.280.000', 'Đang xử lý'),
(61, '4', '31.690.000', '0', '31.690.000', 'Đã nhận hàng'),
(63, '4', '22.990.000', '0', '22.990.000', 'Đã nhận hàng'),
(64, '6', '31.690.000', '0', '31.690.000', 'Đang xử lý'),
(65, '6', '31.690.000', '0', '31.690.000', 'Đã nhận hàng'),
(66, '4', '8.690.000', '0', '8.690.000', 'Đã nhận hàng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phone`
--

CREATE TABLE `phone` (
  `iddienthoai` int(11) NOT NULL,
  `tendienthoai` varchar(255) NOT NULL,
  `gia` varchar(255) NOT NULL,
  `manhinh` varchar(255) NOT NULL,
  `hedieuhanh` varchar(255) NOT NULL,
  `cameratruoc` varchar(255) NOT NULL,
  `camerasau` varchar(255) NOT NULL,
  `chip` varchar(255) NOT NULL,
  `ram` varchar(255) NOT NULL,
  `sim` varchar(255) NOT NULL,
  `pin` varchar(255) NOT NULL,
  `hang` varchar(255) NOT NULL,
  `mausacdf` varchar(255) NOT NULL,
  `bonhodf` varchar(255) NOT NULL,
  `linkdienthoai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phone`
--

INSERT INTO `phone` (`iddienthoai`, `tendienthoai`, `gia`, `manhinh`, `hedieuhanh`, `cameratruoc`, `camerasau`, `chip`, `ram`, `sim`, `pin`, `hang`, `mausacdf`, `bonhodf`, `linkdienthoai`) VALUES
(1, 'Điện thoại iPhone 15 Pro Max', '31.690.001', 'OLED6.7\"Super Retina XDR', 'iOS 17', '12 MP', 'Chính 48 MP & Phụ 12 MP, 12 MP', 'Apple A17 Pro 6 nhân', '8 GB', '1 Nano SIM & 1 eSIMHỗ trợ 5G', '4422 mAh20 W', 'iPhone (Apple)', 'Titan Đen', '256G', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-15-pro-max-black.jpg'),
(2, 'Điện thoại Samsung Galaxy S24 5G', '22.990.000', 'Dynamic AMOLED 2X6.2\"Full HD+', 'Android 14', '12 MP', 'Chính 50 MP & Phụ 12 MP, 10 MP', 'Exynos 2400', '8 GB', '2 Nano SIM hoặc 2 eSIM hoặc 1 Nano SIM + 1 eSIMHỗ trợ 5G', '4000 mAh25 W', 'Samsung', 'Vàng', '256G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s24-yellow.png'),
(3, 'REDMI NOTE 13 PRO', '7.290.000', 'AMOLED 6.67\" Full HD+', 'Android 13', '16 MP', 'Chính 200 MP & Phụ 8 MP, 2 MP', 'MediaTek Helio G99-Ultra 8 nhân', '8 GB', '2 Nano SIMHỗ trợ 4G', '5000 mAh67 W', 'Xiaomi', 'Đen', '128G', 'https://dpna.000webhostapp.com/api/img/xiaomi/Check-out-Black-600x600.png'),
(4, 'Realme C55', '4.990.000', 'IPS LCD6.72\"Full HD+', 'Android 13', '8 MP', 'Chính 64 MP & Phụ 2 MP', 'MediaTek Helio G88', '6 GB', '2 Nano SIMHỗ trợ 4G', '5000 mAh33 W', 'realme', 'Vàng', '6G-128G', 'https://dpna.000webhostapp.com/api/img/realme/realme-c35-vang-thumb-600x600.jpg'),
(5, 'Realme 11', '5.990.000', 'Super AMOLED6.4\"Full HD+', 'Android 13', '16 MP', 'Chính 108 MP & Phụ 2 MP', 'MediaTek Helio G99', '8 GB', '2 Nano SIMHỗ trợ 4G', '5000 mAh67 W', 'realme', 'Vàng', '128G', 'https://dpna.000webhostapp.com/api/img/realme/realme-11-thumb-600x600.jpg'),
(6, 'Oppo A57', '3.890.000', 'IPS LCD6.56\"HD+', 'Android 12', '8 MP', 'Chính 13 MP & Phụ 2 MP', 'MediaTek Helio G35', '4 GB', '2 Nano SIMHỗ trợ 4G', '5000 mAh33 W', 'OPPO', 'Vàng', '128G', 'https://dpna.000webhostapp.com/api/img/oppo/oppo-a57-vang-thumb-600x600.jpg'),
(7, 'OPPO Reno10 5G', '8.690.000', 'AMOLED6.7\"Full HD+', 'Android 13', '32 MP', 'Chính 64 MP & Phụ 32 MP, 8 MP', 'MediaTek Dimensity 7050 5G 8 nhân', '8 GB', '2 Nano SIM (SIM 2 chung khe thẻ nhớ)Hỗ trợ 5G', '5000 mAh67 W', 'OPPO', 'Xanh', '128G', 'https://dpna.000webhostapp.com/api/img/oppo/oppo-reno10-blue-thumbnew-600x600.jpg'),
(8, 'Samsung Galaxy S23 FE 5G', '13.390.000', 'Dynamic AMOLED 2X6.4\"Full HD+', 'Android 13', '10 MP', 'Chính 50 MP & Phụ 12 MP, 8 MP', 'Exynos 2200 8 nhân', '8 GB', '2 Nano SIM hoặc 1 Nano SIM + 1 eSIMHỗ trợ 5G', '4500 mAh25 W', 'Samsung', 'Tím', '128G', 'https://dpna.000webhostapp.com/api/img/samsung/samsung-galaxy-s23-fe-5g-tim-thumb-600x600.jpeg'),
(9, 'realme Note 50 ', '2.490.000', 'IPS LCD6.74\"HD+', 'Android 13', '5 MP', 'Chính 13 MP & Phụ 0.08 MP', 'Unisoc Tiger T612', '3 GB', '2 Nano SIMHỗ trợ 4G', '5000 mAh10 W', 'realme', 'Xanh', '64G', 'https://dpna.000webhostapp.com/api/img/realme/realme-note-50-blue-thumb-600x600.jpg'),
(10, 'iPhone 11 64GB', '9.990.000', 'IPS LCD6.1\"Liquid Retina', 'iOS 15', '12 MP', '2 camera 12 MP', 'Apple A13 Bionic', '4 GB', '1 Nano SIM & 1 eSIMHỗ trợ 4G', '3110 mAh18 W', 'iPhone', 'Trắng', '64G', 'https://dpna.000webhostapp.com/api/img/iphone/iphone-11-trang-600x600.jpg'),
(11, 'Xiaomi Redmi Note 13 Pro+ 5G', '10.490.000', 'AMOLED6.67\"1.5K', 'Android 13', '16 MP', 'Chính 200 MP & Phụ 8 MP, 2 MP', 'MediaTek Dimensity 7200 Ultra', '8 GB', '2 Nano SIMHỗ trợ 5G', '5000 mAh120 W', 'Xiaomi', 'Trắng', '256G', 'https://dpna.000webhostapp.com/api/img/xiaomi/xiaomi-redmi-note-13-pro-plus-white-thumb-600x600.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `storage`
--

CREATE TABLE `storage` (
  `idbonho` int(11) NOT NULL,
  `iddienthoai` int(11) NOT NULL,
  `bonho` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `storage`
--

INSERT INTO `storage` (`idbonho`, `iddienthoai`, `bonho`) VALUES
(1, 1, '256GB'),
(2, 1, '512GB'),
(3, 1, '1T'),
(4, 2, '256G'),
(5, 2, '512G'),
(6, 3, '128G'),
(7, 3, '256G'),
(8, 4, '6G-128G'),
(9, 4, '8G-256G'),
(10, 5, '128G'),
(11, 5, '256G'),
(14, 6, '128G'),
(15, 7, '128G'),
(16, 7, '256G'),
(17, 9, '64G'),
(18, 9, '128G'),
(19, 10, '64G'),
(20, 10, '128G'),
(21, 11, '128G'),
(22, 11, '256G');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `idtaikhoan` int(11) NOT NULL,
  `tentaikhoan` varchar(255) NOT NULL,
  `sodienthoai` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `matkhau` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`idtaikhoan`, `tentaikhoan`, `sodienthoai`, `email`, `matkhau`) VALUES
(4, 'xinchao', '1234567898', 'thanhtan29070906@gmail.com', 'duy123456'),
(5, 'toiladuy', '1234567898', 'ngovuduy9@gmail.com', '12345678'),
(6, 'aaaa', '0000000000', 'a@gmail.com', '00000000'),
(7, 'aaab', '0000000000', 'a@gmail.com', '00000000');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`idgiohang`);

--
-- Chỉ mục cho bảng `chitietdon`
--
ALTER TABLE `chitietdon`
  ADD PRIMARY KEY (`idchitietdon`);

--
-- Chỉ mục cho bảng `color`
--
ALTER TABLE `color`
  ADD PRIMARY KEY (`idmausac`);

--
-- Chỉ mục cho bảng `dondat`
--
ALTER TABLE `dondat`
  ADD PRIMARY KEY (`iddon`);

--
-- Chỉ mục cho bảng `phone`
--
ALTER TABLE `phone`
  ADD PRIMARY KEY (`iddienthoai`);

--
-- Chỉ mục cho bảng `storage`
--
ALTER TABLE `storage`
  ADD PRIMARY KEY (`idbonho`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`idtaikhoan`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `idgiohang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=138;

--
-- AUTO_INCREMENT cho bảng `chitietdon`
--
ALTER TABLE `chitietdon`
  MODIFY `idchitietdon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT cho bảng `color`
--
ALTER TABLE `color`
  MODIFY `idmausac` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT cho bảng `dondat`
--
ALTER TABLE `dondat`
  MODIFY `iddon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT cho bảng `phone`
--
ALTER TABLE `phone`
  MODIFY `iddienthoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT cho bảng `storage`
--
ALTER TABLE `storage`
  MODIFY `idbonho` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `idtaikhoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
