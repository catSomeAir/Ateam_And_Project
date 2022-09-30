package barcord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BarcordServiceImpl implements BarcordService {
	@Autowired private BarcordDAO dao;
}
