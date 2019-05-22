package jenkim49.product;

public class ProductSortSQL {
	// sorting 
	public final static String PRODUCT_READALLCATEGORY= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                ORDER BY\n" + 
			"                    p_no desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READALLCATEGORYNAMEASC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                ORDER BY\n" + 
			"                    p_name asc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READALLCATEGORYNAMEDESC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                ORDER BY\n" + 
			"                    p_name desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READALLCATEGORYPRICEASC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                ORDER BY\n" + 
			"                    p_price asc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READALLCATEGORYPRICEDESC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                ORDER BY\n" + 
			"                    p_price desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READALLCATEGORYPOPULAR= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                ORDER BY\n" + 
			"                    p_count desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READFEMALECATEGORY= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '여성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_no desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READFEMALECATEGORYNAMEASC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '여성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_name asc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READFEMALECATEGORYNAMEDESC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '여성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_name desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READFEMALECATEGORYPRICEASC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '여성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_price asc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READFEMALECATEGORYPRICEDESC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '여성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_price desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READFEMALECATEGORYPOPULAR= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '여성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_count desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READMALECATEGORY= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '남성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_no desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READMALECATEGORYNAMEASC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '남성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_name asc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READMALECATEGORYNAMEDESC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '남성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_name desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READMALECATEGORYPRICEASC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '남성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_price asc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READMALECATEGORYPRICEDESC= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '남성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_price desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
	public final static String PRODUCT_READMALECATEGORYPOPULAR= "SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"        SELECT\n" + 
			"            p.*,\n" + 
			"            ROWNUM AS RNUM\n" + 
			"        FROM\n" + 
			"            (\n" + 
			"                SELECT\n" + 
			"                    DISTINCT p_no,p_category,br_name,p_name,p_volume,p_price,p_image,p_des,p_count,t_name\n" + 
			"                FROM\n" + 
			"                    product\n" + 
			"                WHERE p_category = '남성향수'\n" + 
			"                ORDER BY\n" + 
			"                    p_count desc\n" + 
			"            ) p\n" + 
			"        WHERE\n" + 
			"            ROWNUM <= ?\n" + 
			"    )\n" + 
			"WHERE\n" + 
			"    RNUM > ?";
}
