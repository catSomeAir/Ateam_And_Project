package barcode;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BarcodeDAO implements BarcodeService {
	@Autowired private SqlSession sql;
}
