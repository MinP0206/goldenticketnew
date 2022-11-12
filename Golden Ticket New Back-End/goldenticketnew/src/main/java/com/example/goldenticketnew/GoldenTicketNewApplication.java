package com.example.goldenticketnew;

import com.example.goldenticketnew.model.*;
import com.example.goldenticketnew.repository.*;
import com.example.goldenticketnew.service.user.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
@EnableJpaAuditing
public class GoldenTicketNewApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(GoldenTicketNewApplication.class, args);
	}

//    @Autowired
//    private IUserService userService;
//
    @Autowired
    private IMovieRepository movieRepository;
//
//    @Autowired
//    private IBranchRepository branchRepository;
//
//    @Autowired
//    private IRoomRepository roomRepository;
//
//    @Autowired
//    private IScheduleRepository scheduleRepository;
//
//    @Autowired
//    private ISeatRepository seatRepository;
//
//    // Do chưa có trang admin để thêm phim và lịch chiếu nên thêm tạm dữ liệu xuống db để demo
//    @PostConstruct
//    public void init() {
//        // Chạy 1 lần đầu app rồi bỏ comment đoạn này rồi chạy lại để add data ghế ngồi cho phòng 1
//        Room room = roomRepository.findById(1).get();
//
//        for(int i=1;i<=8;i++){
//            Seat seat = new Seat();
//            seat.setName("A"+i);
//            seat.setRoom(room);
//            seatRepository.save(seat);
//        }
//
//        for(int i=1;i<=8;i++){
//            Seat seat = new Seat();
//            seat.setName("B"+i);
//            seat.setRoom(room);
//            seatRepository.save(seat);
//        }
//        for(int i=1;i<=8;i++){
//            Seat seat = new Seat();
//            seat.setName("C"+i);
//            seat.setRoom(room);
//            seatRepository.save(seat);
//        }
//        for(int i=1;i<=8;i++){
//            Seat seat = new Seat();
//            seat.setName("D"+i);
//            seat.setRoom(room);
//            seatRepository.save(seat);
//        }
//        for(int i=1;i<=8;i++){
//            Seat seat = new Seat();
//            seat.setName("E"+i);
//            seat.setRoom(room);
//            seatRepository.save(seat);
//        }




            // Tạo mới các chi nhánh
//            List<Branch> listBranch = branchRepository.findAll();
//            if(listBranch.isEmpty()){
//                Branch branch1 = new Branch();
//                branch1.setName("HUYCINEMA Hà Đông");
//                branch1.setDiaChi("Tầng 4, Mê Linh Plaza Hà Đông, Đ. Tô Hiệu, P, Hà Đông, Hà Nội");
//                branch1.setPhoneNo("0938473829");
//                branch1.setImgURL("https://www.google.com/maps/vt/data=01jbed2RV46dgYPWYrkUjQ6y9E_UiFnVBsCgIdJWh4TGqJw3K1Qg_A4phqg094CBuRXesGa3QOof0UPRtY3zUWjOKScSn-0JuYoAlbcSKeYWV9wooMdNPaY7iL3Yd9PJjxicmzPKGds-zZRAZ9hqPRix1Trxq2vTQ7GZDWXjNJrqjn2tqL8zO0gSrZgSmarAH0jaD9Ux5tVTaZCwchq2_nNCrs2vjOU7FeXQsPRqfM3jgoYPRe43jeLkd4KGtweeXwUPgV2AeBFj9yTmjBgHSswDBrmGoJkjk-0uRIIO6LCZyMAsSW1p7-gLsUI5nJF6zWCNKmesZ3Jd3I-17zEAOz3AmLMuLkRgiFkICakIuG9B0DkjzVK2P4jN203i4DNkXTpoxKHTMv9dZG-ZoW1A9w7Q5rzSukE8Zdt3GMMei-w-THF-qL3znIiK3nQKq1_BRtnFTvhXduCYpHCo3ZvIiBz4WNKjovXd9ppG-OlRtFLYh8kYvlCKWkO0bmkBeQXoT4mqHQXm80zs_P2CB4xE3bbtoUPgaNo2-5eUcO1CPh6n3DKUdkgOIjRflGoWijmrhJO_45gguPAqZ7ZcXmY_isBf4PnWWJnzO2VAHVQwqwYIJ503CVbm3bmWoX3nVyqThCPj3fFsvjxCH-uYT0VXi3IFc02ktKuirKrsSo2rcgTcTqto0LlmkPAm34wOAr2KmMCfiqJrjKKMCn62v7WefBbU3VLI7Z8pLIgrG4l258FsyN7unVKWcVl3TVnBWp-acw9Y9AmM-nu8OzD7HSpMjJM3X28MJGj9LIIC1WsEdVL0Jhq8x9vBkY9F0RT_XTLQxbIJYa3v0B9x6KlkdOlWqTQTHvc5HQz8OV0JQYp5roWX5WcIx06_gkNOvisnf-J3aeMgzGVGs_-dZUXPwNseutiOPQXyy5NfzhZuJDOAmCJLXEAhmB6BFzFMbATI5zQ9v-D2lDvsjYq2U3Mt7Ctp6HlZVb4DGhzu7FYZkBQ11KkbQthBNKrZQ3kTiVQNNf13Osr9fIK4W6m6R3FtkxqnPshtlc-PYArGqZimsKnxgxxwt1spelowhnI55qFR9wa6UdJgeyGGRfVyfDpFiRKUkwuB7Vip?h=505&w=561&scale=1");
//                branch1 = branchRepository.save(branch1);
//                Room room1 = new Room();
//                room1.setName("Phòng 101");
//                room1.setBranch(branch1);
//                room1.setCapacity(40);
//                room1.setTotalArea(80);
//                room1.setImgURL("http://hdradio.vn/upload/hinhanh/Cinema-tong-hop/cinema-thiet-ke/Cinema-kd100/cinema-hdradio.jpg");
//                Room r1 = roomRepository.save(room1);
//                Schedule schedule1 = new Schedule();
//                schedule1.setBranch(branch1);
//                schedule1.setMovie(nguoiNhen);
//                schedule1.setRoom(r1);
//                schedule1.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule1.setStartTime(LocalTime.parse("10:15"));
//                schedule1.setPrice(70000);
//                scheduleRepository.save(schedule1);
//
//                Schedule schedule5 = new Schedule();
//                schedule5.setBranch(branch1);
//                schedule5.setMovie(nguoiNhen);
//                schedule5.setRoom(r1);
//                schedule5.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule5.setStartTime(LocalTime.parse("13:05"));
//                schedule5.setPrice(70000);
//                scheduleRepository.save(schedule5);
//
//                Schedule schedule6 = new Schedule();
//                schedule6.setBranch(branch1);
//                schedule6.setMovie(nguoiNhen);
//                schedule6.setRoom(r1);
//                schedule6.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule6.setStartTime(LocalTime.parse("14:05"));
//                schedule6.setPrice(70000);
//                scheduleRepository.save(schedule6);
//
//                Schedule schedule7 = new Schedule();
//                schedule7.setBranch(branch1);
//                schedule7.setMovie(nguoiNhen);
//                schedule7.setRoom(r1);
//                schedule7.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule7.setStartTime(LocalTime.parse("16:20"));
//                schedule7.setPrice(70000);
//                scheduleRepository.save(schedule7);
//
//
//                Schedule schedule8 = new Schedule();
//                schedule8.setBranch(branch1);
//                schedule8.setMovie(nguoiNhen);
//                schedule8.setRoom(r1);
//                schedule8.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule8.setStartTime(LocalTime.parse("16:20"));
//                schedule8.setPrice(70000);
//                scheduleRepository.save(schedule8);
//
//                Schedule schedule9 = new Schedule();
//                schedule9.setBranch(branch1);
//                schedule9.setMovie(nguoiNhen);
//                schedule9.setRoom(r1);
//                schedule9.setStartDate(LocalDate.parse("2021-01-06"));
//                schedule9.setStartTime(LocalTime.parse("16:20"));
//                schedule9.setPrice(70000);
//                scheduleRepository.save(schedule9);
//
//                Schedule schedule10 = new Schedule();
//                schedule10.setBranch(branch1);
//                schedule10.setMovie(nguoiNhen);
//                schedule10.setRoom(r1);
//                schedule10.setStartDate(LocalDate.parse("2021-01-06"));
//                schedule10.setStartTime(LocalTime.parse("19:20"));
//                schedule10.setPrice(70000);
//                scheduleRepository.save(schedule10);
//
//                Schedule schedule = new Schedule();
//                schedule.setBranch(branch1);
//                schedule.setMovie(blackPink);
//                schedule.setRoom(r1);
//                schedule.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule.setStartTime(LocalTime.parse("19:15"));
//                schedule.setPrice(70000);
//                scheduleRepository.save(schedule);
//
//                Room room2 = new Room();
//                room2.setName("Phòng 202");
//                room2.setBranch(branch1);
//                room2.setCapacity(40);
//                room2.setTotalArea(80);
//                room2.setImgURL("http://hdradio.vn/upload/hinhanh/Cinema-tong-hop/cinema-thiet-ke/Cinema-kd100/cinema-hdradio.jpg");
//                Room r2 = roomRepository.save(room2);
//                Schedule schedule2 = new Schedule();
//                schedule2.setBranch(branch1);
//                schedule2.setMovie(blackPink);
//                schedule2.setRoom(r2);
//                schedule2.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule2.setStartTime(LocalTime.parse("10:15"));
//                schedule2.setPrice(70000);
//                scheduleRepository.save(schedule2);
//
//                Schedule schedule77 = new Schedule();
//                schedule77.setBranch(branch1);
//                schedule77.setMovie(nguoiNhen);
//                schedule77.setRoom(r2);
//                schedule77.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule77.setStartTime(LocalTime.parse("16:20"));
//                schedule77.setPrice(70000);
//                scheduleRepository.save(schedule77);
//
//
//                Room room3 = new Room();
//                room3.setName("Phòng 303");
//                room3.setBranch(branch1);
//                room3.setCapacity(40);
//                room3.setTotalArea(80);
//                room3.setImgURL("http://hdradio.vn/upload/hinhanh/Cinema-tong-hop/cinema-thiet-ke/Cinema-kd100/cinema-hdradio.jpg");
//                Room r3 = roomRepository.save(room3);
//                Schedule schedule3 = new Schedule();
//                schedule3.setBranch(branch1);
//                schedule3.setMovie(venom);
//                schedule3.setRoom(r3);
//                schedule3.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule3.setStartTime(LocalTime.parse("10:15"));
//                schedule3.setPrice(70000);
//                scheduleRepository.save(schedule3);
//
//                Schedule schedule88 = new Schedule();
//                schedule88.setBranch(branch1);
//                schedule88.setMovie(nguoiNhen);
//                schedule88.setRoom(r3);
//                schedule88.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule88.setStartTime(LocalTime.parse("16:20"));
//                schedule88.setPrice(70000);
//                scheduleRepository.save(schedule88);
//
//                Room room4 = new Room();
//                room4.setName("Phòng 404");
//                room4.setBranch(branch1);
//                room4.setCapacity(40);
//                room4.setTotalArea(80);
//                room4.setImgURL("http://hdradio.vn/upload/hinhanh/Cinema-tong-hop/cinema-thiet-ke/Cinema-kd100/cinema-hdradio.jpg");
//                Room r4 = roomRepository.save(room4);
//
//                Schedule schedule99 = new Schedule();
//                schedule99.setBranch(branch1);
//                schedule99.setMovie(nguoiNhen);
//                schedule99.setRoom(r4);
//                schedule99.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule99.setStartTime(LocalTime.parse("16:20"));
//                schedule99.setPrice(70000);
//                scheduleRepository.save(schedule99);
//
//                Branch branch2 = new Branch();
//                branch2.setName("HUYCINEMA Thủ Đức");
//                branch2.setDiaChi("216 Đ. Võ Văn Ngân, Bình Thọ, Thủ Đức, Thành phố Hồ Chí Minh");
//                branch2.setPhoneNo("1900 6017");
//                branch2.setImgURL("https://www.google.com/maps/vt/data=TZeUNl_xwzxmDpHYWKkbDv_7amlZzoi4kaRvCEATRTtis3KKxsH0tcFvyiR7Gjt4G3NufaHQaPOcn3pMPNABNgbW2ZoipmmEo6PKNCFhm8CuQbuASrxxaRyviyUG78mD1AVOf1D2fJxIjyEmphS20Wo9dgRW8TJBXekAhiaiGu8g");
//                branch2 = branchRepository.save(branch2);
//                room1.setBranch(branch2);
//                room2.setBranch(branch2);
//                room3.setBranch(branch2);
//                Room r5 = roomRepository.save(room1);
//                Room r6 = roomRepository.save(room2);
//                Room r7 = roomRepository.save(room3);
//                Schedule schedule11 = new Schedule();
//                schedule11.setBranch(branch2);
//                schedule11.setMovie(nguoiNhen);
//                schedule11.setRoom(r5);
//                schedule11.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule11.setStartTime(LocalTime.parse("10:15"));
//                schedule11.setPrice(70000);
//                scheduleRepository.save(schedule11);
//
//
//                Branch branch3 = new Branch();
//                branch3.setName("HUYCINEMA Ba Đình");
//                branch3.setDiaChi("29 P. Liễu Giai, Ngọc Khánh, Ba Đình, Hà Nội 100000");
//                branch3.setPhoneNo("1900 6017");
//                branch3.setImgURL("https://www.google.com/maps/vt/data=yhfVddn9tdyWNfmuCzyFU_TR8pm30CLi5oeQTFnFB7qV90WT3OL_ETKkEjQjn3j6zlMuz-VSN_AgZRDCghvF5y2JCVivnwi-sOuKKWT4bSEOf0FZ2-nwoNYSRZH--yH_VpazHsQ9huADdpfR_j3ZnNMEfU_hwJXzSef8AcxHTcqA");
//                branch3 = branchRepository.save(branch3);
//                room1.setBranch(branch3);
//                room2.setBranch(branch3);
//                room3.setBranch(branch3);
//                room4.setBranch(branch3);
//                Room r8= roomRepository.save(room1);
//                Room r9 = roomRepository.save(room2);
//                Room r10 = roomRepository.save(room3);
//                Room r11 = roomRepository.save(room4);
//                Schedule schedule12 = new Schedule();
//                schedule12.setBranch(branch3);
//                schedule12.setMovie(nguoiNhen);
//                schedule12.setRoom(r8);
//                schedule12.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule12.setStartTime(LocalTime.parse("10:15"));
//                schedule12.setPrice(70000);
//                scheduleRepository.save(schedule12);
//                Schedule schedule13 = new Schedule();
//                schedule13.setBranch(branch3);
//                schedule13.setMovie(blackPink);
//                schedule13.setRoom(r9);
//                schedule13.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule13.setStartTime(LocalTime.parse("22:15"));
//                schedule13.setPrice(70000);
//                scheduleRepository.save(schedule12);
//
//                Branch branch4 = new Branch();
//                branch4.setName("HUYCINEMA Phạm Hùng");
//                branch4.setDiaChi("Phạm Hùng, Mỹ Đình, Nam Từ Liêm, Hà Nội");
//                branch4.setPhoneNo("1900 6017");
//                branch4.setImgURL("https://www.google.com/maps/vt/data=YVeSKtAT_T4Tie7xjlIh8lVV_CPmpsr36ayQG-gTEGBZtEKRSSUuLnFbj1HBbGxrYJUS3T3ib8llvuVuiSE85HJYK54JW899mhPMP0BWDwBch-utK9g-_kUPd2rsaEpMLmwUd3R9SO67_S6eUEcY0SfqeXAfB2p9NizW8eGSgD63");
//                branch4 = branchRepository.save(branch4);
//                room1.setBranch(branch4);
//                room2.setBranch(branch4);
//                room3.setBranch(branch4);
//                room4.setBranch(branch4);
//                Room r12 = roomRepository.save(room1);
//                roomRepository.save(room2);
//                roomRepository.save(room3);
//                roomRepository.save(room4);
//
//                Schedule schedule14 = new Schedule();
//                schedule14.setBranch(branch4);
//                schedule14.setMovie(nguoiNhen);
//                schedule14.setRoom(r12);
//                schedule14.setStartDate(LocalDate.parse("2021-01-05"));
//                schedule14.setStartTime(LocalTime.parse("10:15"));
//                schedule14.setPrice(70000);
//                scheduleRepository.save(schedule14);
//            }
//        }
//
//
//
//
//    }
//
    public Movie addNewMovie(
            String name,
            String smallImageURl,
            String shortDescription,
            String longDescription,
            String largeImageURL,
            String director,
            String actors,
            String categories,
            LocalDate releaseDate,
            int duration,
            String trailerURL,
            String language,
            String rated,
            int isShowing) {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setSmallImageURl(smallImageURl);
        movie.setShortDescription(shortDescription);
        movie.setLongDescription(longDescription);
        movie.setLargeImageURL(largeImageURL);
        movie.setDirector(director);
        movie.setActors(actors);
        movie.setCategories(categories);
        movie.setReleaseDate(releaseDate);
        movie.setDuration(duration);
        movie.setTrailerURL(trailerURL);
        movie.setLanguage(language);
        movie.setRated(rated);
        movie.setIsShowing(isShowing);
        movie = movieRepository.save(movie);
        return movie;
    }


}
