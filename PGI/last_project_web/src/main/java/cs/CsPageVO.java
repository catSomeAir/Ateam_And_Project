package cs;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;


	@Component
	public class CsPageVO extends PageVO {
		private List<CsVO> list;

		public List<CsVO> getList() {
			return list;
		}

		public void setList(List<CsVO> list) {
			this.list = list;
		}
}
