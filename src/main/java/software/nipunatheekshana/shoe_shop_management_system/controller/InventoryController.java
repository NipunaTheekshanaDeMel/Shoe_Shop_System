package software.nipunatheekshana.shoe_shop_management_system.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.nipunatheekshana.shoe_shop_management_system.dto.InventoryDTO;
import software.nipunatheekshana.shoe_shop_management_system.exception.NotFoundException;
import software.nipunatheekshana.shoe_shop_management_system.service.InventoryService;
import software.nipunatheekshana.shoe_shop_management_system.util.UtilMatters;


@RestController
@RequestMapping("api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);
    private final InventoryService inventoryService;

    @GetMapping("/check")
    public String checkTest() {
        logger.info("Inventory Checked");
        return "Inventory Check Test";
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveItem(@Valid @ModelAttribute("inventory") InventoryDTO inventoryDTO,
                                      @RequestPart("itemPicture") MultipartFile itemPicture,
                                      Errors errors){
        logger.info("Received request for save a item");
        if (errors.hasFieldErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errors.getFieldErrors().get(0).getDefaultMessage());
        }

        inventoryDTO.setItemPic(UtilMatters.convertBase64(itemPicture));

        try {
            inventoryService.saveInventory(inventoryDTO);
            logger.info("Request processed successfully");
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            logger.error("An exception occurred: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllInventories(){
        logger.info("Received request for get All inventories");
        try {
            return ResponseEntity.ok(inventoryService.getAllInventories());
        }catch (Exception e){
            logger.error("An exception occurred: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSelectedInventory(@PathVariable("id") String id){
        logger.info("Received request for get a inventory");
        try {
            return ResponseEntity.ok(inventoryService.getSelectedInventory(id));
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception e){
            logger.error("An exception occurred: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/sort" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSortedInventory(@RequestParam("sortBy") String sortBy){
        logger.info("Received request for get All inventories");
        try {
            return ResponseEntity.ok(inventoryService.getSortedInventories(sortBy));
        }catch (Exception e){
            logger.error("An exception occurred: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteInventory(@PathVariable("id") String id){
        logger.info("Received request for get a inventory");
        try {
            inventoryService.deleteInventory(id);
            logger.info("Request processed successfully");
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception e){
            logger.error("An exception occurred: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateInventory(@PathVariable("id") String id,
                                             @Valid @ModelAttribute("inventory") InventoryDTO inventoryDTO,
                                             Errors errors){
        logger.info("Received request for update a inventory");
        if (errors.hasFieldErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errors.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            inventoryService.updateInventory(id, inventoryDTO);
            logger.info("Request processed successfully");
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception e){
            logger.error("An exception occurred: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}