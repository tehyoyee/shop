package tehyoyee.github.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tehyoyee.github.shop.dto.ItemSearchDto;
import tehyoyee.github.shop.entity.Item;

public interface ItemRepositoryCustom {

	Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

}
