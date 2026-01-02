package com.quickstay.hotelportal.service;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.quickstay.hotelportal.dto.RoomDTO;
import com.quickstay.hotelportal.entity.Room;

public interface RoomService {

 Room addRoom(RoomDTO dto, List<MultipartFile> images) throws Exception;
 List<Room> getAllRooms();
 Room getRoomById(Long id);
 Room updateRoomAvailability(Long id,boolean isAvailable);
 void deleteRoomById(Long id);
 Room updateRoom(Long id,RoomDTO dto,List<MultipartFile> images) throws IOException;
}
