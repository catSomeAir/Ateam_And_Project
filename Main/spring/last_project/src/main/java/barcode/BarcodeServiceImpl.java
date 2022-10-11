package barcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BarcodeServiceImpl implements BarcodeService {
	@Autowired private BarcodeDAO dao;
}
