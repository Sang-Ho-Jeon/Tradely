-- 1. File MetaData --
INSERT INTO file_metadata ( 
member_id, file_path, file_name, file_category, 
display_name, content_type, file_size, is_deleted, uploaded_at
)
VALUES 
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/f97988b6-3fc2-4727-b45e-75841b8e9e77.png','f97988b6-3fc2-4727-b45e-75841b8e9e77.png','icon',
  'producttype_domestic_stocks.png','image/png',1988, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/98b02a08-403a-461a-9ac8-80a398f27801.png', '98b02a08-403a-461a-9ac8-80a398f27801.png', 'icon',
  'producttype_foreign_stocks.png', 'image/png', 2568, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/c230bd25-4f64-4df5-a2a3-a9fba00276f7.png', 'c230bd25-4f64-4df5-a2a3-a9fba00276f7.png', 'icon',
  'producttype_foreign_stock_option.png', 'image/png', 3658, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/c61a03d1-cbc6-4131-b4ac-d5f883c8145b.png', 'c61a03d1-cbc6-4131-b4ac-d5f883c8145b.png', 'icon',
  'producttype_domestic_etf.png', 'image/png', 1263, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/a793cfe1-7ed7-404f-8ea6-7457501fc64b.png', 'a793cfe1-7ed7-404f-8ea6-7457501fc64b.png', 'icon',
  'producttype_foreign_etf.png', 'image/png', 2025, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/f65b6b21-ec4a-451a-9bd1-deaa6e3c03df.png', 'f65b6b21-ec4a-451a-9bd1-deaa6e3c03df.png', 'icon',
  'producttype_foreign_index_futures.png', 'image/png', 3399, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/14153a96-905b-4129-ba2f-a828a8c00a03.png', '14153a96-905b-4129-ba2f-a828a8c00a03.png', 'icon',
  'producttype_foreign_commodity_futures.png', 'image/png', 3547, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/dcced58c-ac96-43f5-8233-92a07db78029.png', 'dcced58c-ac96-43f5-8233-92a07db78029.png', 'icon',
  'producttype_domestic_index_futures.png', 'image/png', 2866, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/4935fca9-74e7-4a72-a57b-fd30e380ffc3.png', '4935fca9-74e7-4a72-a57b-fd30e380ffc3.png', 'icon',
  'producttype_domestic_commodity_futures.png', 'image/png', 2999, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/c5ca692b-7e16-4115-8fe3-a552f0f8e0c3.png', 'c5ca692b-7e16-4115-8fe3-a552f0f8e0c3.png', 'icon',
  'producttype_domestic_index_option.png', 'image/png', 3179, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/92d70f53-1d29-4704-a21c-6d8be8f85bc0.png', '92d70f53-1d29-4704-a21c-6d8be8f85bc0.png', 'icon',
  'tradetype_A.png', 'image/png', 917, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/d3bd6274-2be5-4efe-8ec1-6736979821e6.png', 'd3bd6274-2be5-4efe-8ec1-6736979821e6.png', 'icon',
  'tradetype_H.png', 'image/png', 436, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/701a31eb-5c79-4d9d-b1f2-a3ed2e18d179.png', '701a31eb-5c79-4d9d-b1f2-a3ed2e18d179.png', 'icon',
  'tradetype_P.png', 'image/png', 756, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/1ec1159d-4494-450f-ae75-43f4e3674e98.png', '1ec1159d-4494-450f-ae75-43f4e3674e98.png', 'icon',
  'tradingcycle_day.png', 'image/png', 1275, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/46ba0897-bc11-495d-bffc-0af048073d83.png', '46ba0897-bc11-495d-bffc-0af048073d83.png', 'icon',
  'tradingcycle_position.png', 'image/png', 1752, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/60685555-0d9b-46ea-9899-2cd5f004c597.png', '60685555-0d9b-46ea-9899-2cd5f004c597.png', 'icon',
  'producttype_domestic_stock_option.png', 'image/png', 3153, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/d7da6ce1-13f9-4362-98bf-3b12bd937aeb.png', 'd7da6ce1-13f9-4362-98bf-3b12bd937aeb.png', 'icon',
  'producttype_foreign_index_option.png', 'image/png', 3686, 0, now()),
('admin', 'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/7745bc6a-3837-4c00-a5b4-5264c047cc00.png', '7745bc6a-3837-4c00-a5b4-5264c047cc00.png', 'icon',
  'logo.png', 'image/png', 11438, 0, now())
;

-- 2. 투자자산 분류 --
INSERT INTO investment_asset_classes (
        investment_asset_classes_order, investment_asset_classes_name, 
        investment_asset_classes_icon, introduce
) VALUES (
        1, '국내주식', 
        'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/f97988b6-3fc2-4727-b45e-75841b8e9e77.png', '국내주식은 국내의 주식입니다.'
    );
    

    INSERT INTO investment_asset_classes (
        investment_asset_classes_order, investment_asset_classes_name, 
        investment_asset_classes_icon, introduce
    ) VALUES (
		2, '해외주식', 
        'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/98b02a08-403a-461a-9ac8-80a398f27801.png', '해외주식은 해외의 주식입니다.'
    );
    

    INSERT INTO investment_asset_classes (
        investment_asset_classes_order, investment_asset_classes_name, 
        investment_asset_classes_icon, introduce
    ) VALUES (
        3, '해외주식 옵션', 
        'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/c230bd25-4f64-4df5-a2a3-a9fba00276f7.png', '해외주식의 옵션 상품을 다룹니다.'
    );
    

    INSERT INTO investment_asset_classes (
        investment_asset_classes_order, investment_asset_classes_name, 
        investment_asset_classes_icon, introduce
    ) VALUES (
        4, '국내ETF', 
        'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/c61a03d1-cbc6-4131-b4ac-d5f883c8145b.png', '국내 ETF는 국내 펀드 종목입니다.'
    );
    

    INSERT INTO investment_asset_classes (
		investment_asset_classes_order, investment_asset_classes_name, 
        investment_asset_classes_icon, introduce
    ) VALUES (
        5, '해외ETF', 
        'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/a793cfe1-7ed7-404f-8ea6-7457501fc64b.png', '해외 ETF는 해외 펀드 종목입니다.'
    );
    

    INSERT INTO investment_asset_classes (
        investment_asset_classes_order, investment_asset_classes_name, 
        investment_asset_classes_icon, introduce
    ) VALUES (
        6, '해외지수선물', 
        'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/f65b6b21-ec4a-451a-9bd1-deaa6e3c03df.png', '해외 지수 선물은 지수를 따르는 선물상품입니다.'
    );
    

    INSERT INTO investment_asset_classes (
        investment_asset_classes_order, investment_asset_classes_name, 
        investment_asset_classes_icon, introduce
    ) VALUES (
        7, '해외상품선물', 
        'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/14153a96-905b-4129-ba2f-a828a8c00a03.png', '특정 삼품을 일정 기간에 거래하는 종목입니다.'
    );
    

    INSERT INTO investment_asset_classes (
        investment_asset_classes_order, investment_asset_classes_name, 
        investment_asset_classes_icon, introduce
    ) VALUES (
        8, '국내지수선물', 
        'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/dcced58c-ac96-43f5-8233-92a07db78029.png', '국내 지수 선물은 지수를 따르는 선물상품입니다.'
    );
    

    INSERT INTO investment_asset_classes (
        investment_asset_classes_order, investment_asset_classes_name, 
        investment_asset_classes_icon, introduce
    ) VALUES (
        9, '국내상품선물', 
        'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/4935fca9-74e7-4a72-a57b-fd30e380ffc3.png', '특정 삼품을 일정 기간에 거래하는 종목입니다.'
    );
    

    INSERT INTO investment_asset_classes (
        investment_asset_classes_order, investment_asset_classes_name, 
        investment_asset_classes_icon, introduce
    ) VALUES (
        10, '국내지수옵션', 
        'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/c5ca692b-7e16-4115-8fe3-a552f0f8e0c3.png', '국내 지수에 대한 옵션 상품을 다룹니다.'
    );
    

    INSERT INTO investment_asset_classes (
        investment_asset_classes_order, investment_asset_classes_name, 
        investment_asset_classes_icon, introduce
    ) VALUES (
        11, 'F/X', 
        'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/57f0adce-939e-4cf8-b9b2-1b7221f66fbf.png', 'FX 마진 거래를 다룹니다.'
    );


-- 3. 매매유형 --    
    INSERT INTO trading_type (
		trading_type_id, trading_type_order, trading_type_name,
        trading_type_icon, trading_type_description, is_active
        ) VALUES (
			1, 3, '자동',
            'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/92d70f53-1d29-4704-a21c-6d8be8f85bc0.png', '자동매매방식입니다.', 'Y'
	);
    
    INSERT INTO trading_type (
		trading_type_id, trading_type_order, trading_type_name,
        trading_type_icon, trading_type_description, is_active
        ) VALUES (
			2, 2, '하이브리드',
            'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/d3bd6274-2be5-4efe-8ec1-6736979821e6.png', '자동과 수동을 섞은 매매방식입니다.', 'Y'
	);
    
    INSERT INTO trading_type (
		trading_type_id, trading_type_order, trading_type_name,
        trading_type_icon, trading_type_description, is_active
        ) VALUES (
			3, 1, '수동',
            'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/701a31eb-5c79-4d9d-b1f2-a3ed2e18d179.png', '수동매매방식입니다.', 'Y'
	);

-- 4. 매매 주기 --
    INSERT INTO trading_cycle (
		trading_cycle_id, trading_cycle_order, trading_cycle_name,
        trading_cycle_icon, trading_cycle_description, is_active
        ) VALUES (
			1, 2, '데이',
            'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/1ec1159d-4494-450f-ae75-43f4e3674e98.png', '데이매매방식입니다.', 'Y'
	);
    
        INSERT INTO trading_cycle (
		trading_cycle_id, trading_cycle_order, trading_cycle_name,
        trading_cycle_icon, trading_cycle_description, is_active
        ) VALUES (
			2, 1, '포지션',
            'https://fastcampus-team2.s3.ap-northeast-2.amazonaws.com/admin/icon/46ba0897-bc11-495d-bffc-0af048073d83.png', '데이매매방식입니다.', 'Y'
	);
