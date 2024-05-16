const content = document.getElementById("content");

var urlParams = new URLSearchParams(window.location.search);
var id = urlParams.get("id");

if(id == 1) {
    content.innerHTML = `
        <p>Ra mắt Realme 12+ thiết kế cực sang, giá chưa tới 7 triệu đồng</p>
        <p>Đúng như dự đoán, Realme 12+ đã chính thức ra mắt. Sản phẩm có màn hình AMOLED 6,7 inch với độ phân giải FHD + và tốc độ làm mới 120Hz cùng một chi tiết "đục lỗ" chứa camera selfie 16MP. Thêm nữa, màn hình cũng tích hợp máy quét dấu vân tay đi kèm khả năng theo dõi nhịp tim.</p>
        <p>Mặt sau của điện thoại Realme có thiết kế bằng da thuần chay giống như Realme 12 Pro và Realme 12 Pro+ với cụm camera hình tròn lớn chứa ba camera.</p>
        <p>Camera chính của máy sử dụng cảm biến Sony LYT-600 50MP với khẩu độ f/1.88 và dải tiêu cự tương đương 26mm. Cảm biến này cung cấp khả năng zoom 2x với chế độ chân dung chuyên dụng và có tính năng Chống rung quang học - OIS. Ngoài ra, Realme cũng bổ sung thêm một ống kính góc siêu rộng 8MP với tiêu cự 16mm, khẩu độ f/2.2 và một camera chụp cận - macro 2MP.</p>
        <p>Bên trong thiết bị là con chip Dimensity 7050 kết hợp với RAM 8GB và bộ nhớ trong 256GB. Về phần mềm, điện thoại được bao phủ bởi giao diện người dùng Realme UI 5.0 dựa trên hệ điều hành Android 14. Thiết bị được cung cấp năng lượng từ viên pin 5.000 mAh với khả năng sạc 67W.</p>
        <p>Realme 12+ có 2 tuỳ chọn màu: Be Navigator và Xanh Pioneer. Giá bán của chiếc smartphone tầm trung này khá hấp dẫn, ở mức 4.199.000 Rupiah Indonesia (khoảng 267 USD - 6,59 triệu đồng) tại Indonesia. Thời gian mở bán của smartphone bắt đầu vào ngày 8/3.</p>
    `;
}
else if (id == 2) {
    content.innerHTML = `
        <p>Những tính năng trên Xiaomi 14 Ultra khiến iPhone xấu hổ</p>     
        <p>Tại Triển lãm di động toàn cầu - MWC 2024 năm nay, Xiaomi có rất nhiều hoạt động diễn ra tại gian hàng của mình. Hãng không chỉ có ô tô điện Xiaomi SU7, nhiều đồng hồ thông minh và chó robot, chiếc điện thoại Xiaomi 14 Ultra mới cũng khiến nhiều chuyên gia công nghệ chú ý.</p>
        <p>Xiaomi 14 Ultra đặc biệt phù hợp đối với những người sáng tạo như nhiếp ảnh gia, hỗ trợ sạc không dây 80 watt, camera chính có cảm biến hình ảnh lớn và ống kính góc rộng trên camera chính có khẩu độ thay đổi cực linh hoạt.</p>
        <p>Một camera tele có tiêu cự lên tới 75mm (zoom 3,2x) và camera tele còn lại có tiêu cự 120mm (zoom 5x). Xiaomi không phải là thương hiệu smartphone đầu tiên tích hợp 2 camera tele. Trước đó, Galaxy S24 Ultra của Samsung đã có ống kính tele zoom 3x và zoom 5x riêng biệt. Và giống như Xiaomi 14 Ultra, điện thoại cao cấp nhất của Samsung cũng có 4 camera sau. Trên thực tế, ống kính zoom 3x của Galaxy S24 Ultra vượt trội hơn iPhone 15 Pro Max.</p>
        <p>iPhone 15 Pro Max chỉ có một camera tele 5x nên đối với ảnh zoom 3x, điện thoại chủ yếu dựa vào zoom kỹ thuật số. Ảnh chụp ở độ zoom này không tệ nhưng không đẹp bằng ảnh zoom 3x của Galaxy S24 Ultra.</p>
        <p>Do đó, Apple nên bổ sung một camera tele thứ hai, ngắn hơn như Xiaomi và Samsung. Ví dụ, iPhone 16 Ultra có thể kết hợp camera tele zoom 3x của iPhone 15 Pro và camera zoom 5x của iPhone 15 Pro Max!</p>
        <p>Apple ra mắt tính năng sạc MagSafe trên dòng iPhone 12 vào năm 2020 giúp sạc không dây hiệu quả hơn. Nhưng vào năm 2024, sạc không dây MagSafe chỉ đạt công suất 15 watt. Trong khi đó, Xiaomi 14 Pro đã hỗ trợ sạc không dây lên đến 80 watt. Tốc độ này nhanh hơn 3 lần so với tốc độ sạc có dây tối đa 27 watt của iPhone 15.</p>
        `;
        
}
else if(id == 3) {
    content.innerHTML = `
    <p>Không cần điện thoại Samsung cũng có thể truy cập Galaxy AI</p>
    <p>Samsung vừa ra mắt ứng dụng Try Galaxy dành cho các thiết bị Android, bao gồm cả các mẫu máy không phải Galaxy, để cung cấp cho người dùng trải nghiệm về các tính năng Galaxy AI mới. Ứng dụng cho phép người dùng dùng thử Live Translate, Chat Assist, Note Assist, Photo Assist và Circle to Search with Google mà không cần mua thiết bị Galaxy S24 mới nhất.</p>
    <p>Sau khi đặt ứng dụng, người dùng sẽ nhận được một loạt hướng dẫn về cách điều hướng One UI 6.1. Tiện ích trên trang thứ hai đóng vai trò là danh sách kiểm tra các tính năng do AI cung cấp để thử. Theo Samsung, người dùng có thể nhấn vào từng mục để xem các video trình diễn ngắn giải thích các tính năng và cách chúng được áp dụng trong cuộc sống hàng ngày.</p>
    <p>Ngoài ra, người dùng cũng có thể dùng thử các chủ đề Galaxy hoặc hình nền mới được cung cấp độc quyền trên Galaxy S24 Ultra. Sản phẩm bao gồm phần thưởng và ba loại hình nền nghệ thuật có sẵn để tải xuống.</p>
    <p>Quay trở lại với khi ra mắt dòng Galaxy S24, Samsung đã quyết định tích hợp AI trên smartphone của mình và gọi đây là kỷ nguyên mới của AI di động bằng cách cung cấp một số tính năng AI mà người dùng Samsung sẽ yêu thích.</p>
    <p>Bắt đầu từ năm 2022, Samsung đã sử dụng ứng dụng Try Galaxy để quảng bá các tính năng mới trên điện thoại của mình. Công ty Hàn Quốc xem việc cung cấp cái nhìn thoáng qua về trải nghiệm trên các mẫu điện thoại của họ sẽ là cách để lôi kéo mọi người mua chúng.</p>

    `
}
else if(id == 4) {
    content.innerHTML = `
    <p>Phát hiện bất ngờ thú vị khi người dùng Android chuyển sang iPhone</p>
    <p>Dữ liệu mới nhất từ CIRP chỉ ra rằng tỷ lệ người dùng Android chuyển sang iPhone vẫn ở mức khá hẹp trong vài năm qua, từ 11% đến 15%.</p>
    <p>Từ năm 2019 đến năm 2023, tỷ lệ người mua iPhone chuyển từ Android sang iOS như sau: 2019 (13%), 2020 (11%), 2021 (11%), 2022 (15%) và 2023 (13%). CIRP cho biết trong báo cáo mới nhất rằng những người dùng Android chuyển sang sử dụng iPhone là nam giới và kiếm được ít tiền hơn những người dùng iPhone hiện tại. Hầu hết những người mua iPhone này đều chuyển sang mẫu cũ để tiết kiệm tiền, đồng thời có một tỷ lệ đáng ngạc nhiên người dùng chuyển đổi chọn mua mẫu Pro hoặc Pro Max mới nhất.</p>
    <p>Trong suốt 12 tháng của năm 2023, 29% người dùng Android chuyển sang iPhone đã mua các mẫu iPhone SE 3, iPhone 12 và iPhone 13/13 mini. Điều thú vị ở đây là tỷ lệ chủ sở hữu iPhone nâng cấp lên một trong những model đó thấp hơn, ở mức 21% trong cùng khoảng thời gian. Trong năm 2023, 51% người chuyển đổi Android mua mẫu iPhone 14 series (dòng mới nhất trong suốt 3/4 của năm), còn số người dùng iPhone nâng cấp lên các mẫu này là 56%.</p>
    <p>CIRP phát hiện ra rằng 37% người chuyển đổi từ Android đã mua mẫu iPhone 14 Pro series hoặc iPhone 15 Pro series, trong khi số người dùng iPhone nâng cấp lên một trong những mẫu này là 43%.</p>
    <p>Vậy tại sao người dùng Android chuyển sang iPhone thường bắt đầu bằng một trong những điện thoại giá thấp hơn? CIRP gợi ý rằng một lý do có thể là nhiều trong số này đến từ người dùng điện thoại Android giá thấp hơn và các mẫu iPhone cũ cũng như không phải Pro phù hợp với túi tiền của họ.</p>
     `
}
else if(id == 5) {
    content.innerHTML = `
    <p>Rò rỉ lớn về chip xử lý trên loạt iPhone và iPad sắp ra mắt</p>
    <p>Cộng đồng hâm mộ các sản phẩm của “nhà Táo” vẫn đang háo hức chờ đợi những thông tin của thế hệ thiết bị Apple tiếp theo.</p>
    <p>Theo PhoneArena, một thông tin rò rỉ mới đã được đăng tải trên AppleInsider, đến từ một nguồn tin ẩn danh có thành tích cung cấp đáng tin cậy, đã hé lộ về thông tin chip xử lý thế hệ tiếp theo trên iPhone và iPad sắp ra mắt.</p>
    <p>Hai thiết bị đầu tiên được rò rỉ sẽ được trang bị chip A14 Bionic ra mắt năm 2020, được cho là hai phiên bản khác nhau của iPad giá rẻ. Vì iPad thế hệ thứ 10 hiện tại đã sử dụng chip A14 Bionic, nên các thiết bị này có thể là iPad thế hệ thứ 10 với cấu hình nâng cấp dành riêng cho lĩnh vực giáo dục.</p>
    <p>Tiếp theo, hai phiên bản iPad mini 2024 sẽ được nâng cấp từ chip A15 Bionic lên chip A17 Pro 3nm, tương tự như chip được trang bị trên iPhone 15 Pro và iPhone 15 Pro Max. Hiện tại, đây là hai chiếc điện thoại duy nhất sử dụng chipset 3nm.</p>
    <p>Theo nguồn tin rò rỉ, iPad Air năm nay sẽ có thêm phiên bản 12.9 inch bên cạnh phiên bản 10.9 inch mặc định. Kích thước này gần giống với màn hình 11 inch và 12.9 inch trên iPad Pro (2022). Apple hy vọng rằng việc bổ sung thêm phiên bản với hai kích thước màn hình này sẽ thu hút người mua mà không ảnh hưởng đến doanh số bán của iPad Pro.</p>

     `
}

else if(id == 6) {
    content.innerHTML = `
    <p>OnePlus 12R Genshin Impact ra mắt với màu tím nổi bật, hấp dẫn mọi game thủ</p>
    <p>OnePlus 12R Genshin Impact Edition có thiết kế siêu ấn tượng, tích hợp cấu hình "ngon" và sở hữu giá bán hấp dẫn.</p>
    <p>OnePlus 12R vừa mới ra mắt vào tháng trước. Đây là một chiếc điện thoại tầm trung có ngoại hình khá đẹp với mức giá hấp dẫn, hiệu năng mượt mà và thời lượng pin ấn tượng. Và giờ đây, công chúng đã có phiên bản OnePlus 12R Genshin Impact siêu đẹp!</p>
    <p>Thực tế là 2 sản phẩm này không có nhiều khác biệt - chúng có cùng bộ xử lý Qualcomm Snapdragon 8 Gen 2, RAM 16GB, bộ nhớ trong 256GB. Phần mềm của phiên bản Genshin Impact tương tự như OnePlus 12R tiêu chuẩn nhưng có một chút thay đổi.</p>
    <p>Thứ nhất, toàn bộ chủ đề với hình nền, biểu tượng và âm thông báo đều được lấy cảm hứng từ nhân vật Kequing với toàn màu tím. Hình ảnh của nhân vật này cũng xuất hiện trên hình nền và giọng nói, tạo hiệu ứng âm thanh chân thực (nữ diễn viên lồng tiếng cho nhân vật này đã ghi âm lời thoại cho điện thoại OnePlus).</p>
    <p>Thứ hai, OnePlus tuyên bố, sản phẩm đã có những điều chỉnh phần mềm đặc biệt để tối ưu hóa cụ thể việc chơi game bên trong Genshin. Trò chơi sẽ tải các điểm di chuyển nhanh hơn và thậm chí sẽ vẫn mở ở chế độ nền khi người dùng thu nhỏ trò chơi.</p>
    <p>Thứ ba, OnePlus 12R Genshin Impact Edition đi kèm một hộp sưu tập quà tặng. Vỏ, bộ sạc và cáp đều có màu tím đặc biệt; hình dán Chibi, ghim và chân đế, ngay cả que đẩy SIM cũng được lấy cảm hứng từ trang phục của Kequing.</p>
    <p>Phiên bản OnePlus 12R Genshin Impact sẽ được mở bán vào ngày 21/3, có giá bán từ 649,99 USD (tương đương 16 triệu đồng). Phiên bản này đắt hơn khoảng 150 USD (khoảng 3,6 triệu đồng) so với giá của OnePlus 12R tiêu chuẩn. Nhìn chung, đây sẽ là một sản phẩm cực ấn tượng với các fan hâm mộ Genshin!</p>
     `
}

