package com.app.demo;

import android.app.Application;

import com.app.utils.AppDir;
import com.app.utils.FrescoUtil;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

import org.litepal.LitePal;


public class MyApplication extends Application {

    private static MyApplication instance;


    @Override
    public void onCreate() { //創建應用程式
        super.onCreate();

        instance = this;
        if (instance != null) {
            //數據庫初始化
            LitePal.initialize(instance);

            //創建應用程式快取路徑
            AppDir.getInstance(this);

            //fresco初始化
            FrescoUtil.init(instance);

            initMap();

        }
    }

    private void initMap() {

        SDKInitializer.setCoordType(CoordType.BD09LL);
    }


    public static MyApplication getInstance() {
        return instance;
    }


    //數據
    //線上圖片
    public static String[] picUrls = {
            "https://i.imgur.com/qUvp8YC.jpeg",
            "https://i.imgur.com/c83672M.jpeg",

            "https://i.imgur.com/Jcjoaru.jpeg",
            "https://i.imgur.com/2VmVaGe.jpeg",

            "https://i.imgur.com/uNzo9od.jpeg",
            "https://i.imgur.com/825Gg63.jpeg",




            "https://i.imgur.com/F9Iqmda.jpeg",
            "https://i.imgur.com/UJPTs0P.jpeg",


            "https://i.imgur.com/MTio6Wc.jpeg",
            "https://i.imgur.com/eCATqwD.jpeg",


            "https://i.imgur.com/dQkYNoQ.jpeg",
            "https://i.imgur.com/FxNXfxF.jpeg",

            "https://i.imgur.com/xiVsLe2.jpeg",
            "https://i.imgur.com/2DsLnzj.jpeg",


            "https://i.imgur.com/0fTDYwN.jpeg",
            "https://i.imgur.com/oIgQZaS.jpeg",


            "https://i.imgur.com/8jN3pJd.jpeg",
            "https://i.imgur.com/7Abo9M6.jpeg",


            "https://i.imgur.com/vUtgJTq.jpeg",
            "https://i.imgur.com/SW6j2z2.jpeg",


    };
    //名稱
    public static String[] names = {
            "馬偕上岸處 ",
            "馬偕上岸處 ",

            "馬偕博士雕像 ",
            "馬偕博士雕像 ",


            "真理理學堂大書院 ",
            "真理理學堂大書院 ",


            "淡水雲門劇場 ",
            "淡水雲門劇場 ",


            "滬尾偕醫館 ",
            "滬尾偕醫館 ",


            "金色水岸 ",
            "金色水岸 ",


            "大禮拜堂 ",
            "大禮拜堂 ",


            "淡水紅毛城",
            "淡水紅毛城",


            "淡水漁人碼頭",
            "淡水漁人碼頭",


            "情人橋 ",
            "情人橋 ",
    };


    // 英文名稱
    public static String[] namesEn = {
            "Mackay's Landing Site",
            "Dr. Mackay Statue",
            "Tamsui Oxford College",
            "Cloud Gate",
            "Hobe Mackay Clinic",
            "Golden Waterfront",
            "Great Chapel",
            "Fort San Domingo",
            "Tamsui Fisherman's Wharf",
            "Love Bridge"
    };

    // 日文名稱
    public static String[] namesJa = {
            "マッカイ上陸地点",
            "マッカイ博士像",
            "真理学堂大书院",
            "淡水クラウドゲートシアター",
            "ホベ・マッカイ病院",
            "ゴールデン・ウォーターフロント",
            "大礼拝堂",
            "フォート・サン・ドミンゴ",
            "タムシウ漁港",
            "ラブ・ブリッジ"
    };

    // 韩文名稱
    public static String[] namesKo = {
            "막사이 상륙지점",
            "막사이 박사 동상",
            "진리학당 대서원",
            "클라우드 게이트 극장",
            "호베 막사이 병원",
            "골든 워터프론트",
            "대예배당",
            "포트 산도미ngo",
            "탄수어부항",
            "러브 브릿지"
    };


    //簡介
    public static String[] conts = {
            "位於淡水郵局後方河岸處，由國立臺北藝術大學陳愷璜先生所作，銅像設計為馬偕上岸的意象，又稱「馬偕藝術銅像」；馬偕博士手捧聖經跪在地面上禱告，位於他身旁的是他搭乘而來的小船，因此，此景點全稱為「馬偕上岸小方舟及馬偕禱告雕像」。1872年3月9日下午3時，加拿大宣教士馬偕博士搭「海龍號」由此登陸，自此以淡水為其宣教、醫療和教育之基地，並擇淡水為家，在此娶妻生子，死後埋骨於斯土。",
            "位於淡水郵局後方河岸處，由國立臺北藝術大學陳愷璜先生所作，銅像設計為馬偕上岸的意象，又稱「馬偕藝術銅像」；馬偕博士手捧聖經跪在地面上禱告，位於他身旁的是他搭乘而來的小船，因此，此景點全稱為「馬偕上岸小方舟及馬偕禱告雕像」。1872年3月9日下午3時，加拿大宣教士馬偕博士搭「海龍號」由此登陸，自此以淡水為其宣教、醫療和教育之基地，並擇淡水為家，在此娶妻生子，死後埋骨於斯土。",

            "喬治·萊斯里·馬偕（George Leslie Mackay，1844年3月21日-1901年6月2日）生於加拿大安大略省，加拿大長老會差會牧師，雖然不是醫師但學過解剖學與生理學課程。將生命奉獻給臺灣的牧師。漢名叫偕睿理，但一般稱「馬偕博士」。於19世紀末期至台灣傳教與行醫，與馬雅各齊名。馬偕的一生被以「寧願燒盡，不願鏽壞」讚賞。",
            "喬治·萊斯里·馬偕（George Leslie Mackay，1844年3月21日-1901年6月2日）生於加拿大安大略省，加拿大長老會差會牧師，雖然不是醫師但學過解剖學與生理學課程。將生命奉獻給臺灣的牧師。漢名叫偕睿理，但一般稱「馬偕博士」。於19世紀末期至台灣傳教與行醫，與馬雅各齊名。馬偕的一生被以「寧願燒盡，不願鏽壞」讚賞。",


            "理學堂大書院是全臺灣第一座西式學堂，於1882年由馬偕博士於故鄉加拿大牛津郡募款創立，位於真理大學內，又名牛津學堂，1985年經內政部指定為二級古蹟，如今成為真理大學校史館，陳展學校與馬偕相關文史資料。 ",
            "理學堂大書院是全臺灣第一座西式學堂，於1882年由馬偕博士於故鄉加拿大牛津郡募款創立，位於真理大學內，又名牛津學堂，1985年經內政部指定為二級古蹟，如今成為真理大學校史館，陳展學校與馬偕相關文史資料。 ",


            "位於淡水高爾夫球場與滬尾砲台之間的雲門劇場，遠眺觀音山與淡水河出海口，淡綠玻璃帷幕的建築映照周遭高樹，融入恬靜的綠色地景。" +
                    "\n" +
                    "建築內部規劃出 劇場、小劇場、辦公空間、佈景工廠、舞者休息室，交錯連結，人員可以迅速穿梭，又能獨立工作。室外的部分，從入口的廊道，央廣屋頂改建的平台，到通往草坪的寬大階梯，一氣呵成。民眾倘佯戶外空間，進入室內劇場觀賞演出，共同參與雲門新文化的塑造。 ",
            "位於淡水高爾夫球場與滬尾砲台之間的雲門劇場，遠眺觀音山與淡水河出海口，淡綠玻璃帷幕的建築映照周遭高樹，融入恬靜的綠色地景。" +
                    "\n" +
                    "建築內部規劃出 劇場、小劇場、辦公空間、佈景工廠、舞者休息室，交錯連結，人員可以迅速穿梭，又能獨立工作。室外的部分，從入口的廊道，央廣屋頂改建的平台，到通往草坪的寬大階梯，一氣呵成。民眾倘佯戶外空間，進入室內劇場觀賞演出，共同參與雲門新文化的塑造。 ",


            "滬尾偕醫館，是新北市古蹟之一，也是臺灣第一家西式醫院，成立於1879年9月14日，由馬偕醫生主持，此處也曾是他的住所\n",
            "滬尾偕醫館，是新北市古蹟之一，也是臺灣第一家西式醫院，成立於1879年9月14日，由馬偕醫生主持，此處也曾是他的住所\n",


            " 大家所熟悉的淡水河岸，其實有條名聲很優雅的自行車道，叫做「金色水岸」，起點自關渡宮附近的中港河入口一直沿著河岸到淡水老街。 這條自行車道長約10公里，非常平整好騎，很適合親子一起觀察白鷺鷥與招潮蟹等生態，一邊享受騎乘樂趣。騎到鼎鼎大名的「淡水老街」，在街道兩旁林立熱鬧的商店，包含有濃濃古早味的米行、餅舖、布店、雜貨店等；以及充滿現代感的潮流服飾、玩具等，形成古今交融的特殊商圈文化。老街裡可以尋寶、品嚐美食，還有古蹟可參觀，怎麼玩都不會膩，是遊人必去的超人氣景點。老街分成外側靠淡水河岸的部分(金色水岸步道)與內側的老街，著名在地特產包括古早味現烤蛋糕、阿給、烤魷魚、阿婆鐵蛋、魚酥、巨無霸冰淇淋、魚丸等等，都是來老街非吃不可的美食。",

                    "大家所熟悉的淡水河岸，其實有條名聲很優雅的自行車道，叫做「金色水岸」，起點自關渡宮附近的中港河入口一直沿著河岸到淡水老街。 這條自行車道長約10公里，非常平整好騎，很適合親子一起觀察白鷺鷥與招潮蟹等生態，一邊享受騎乘樂趣。騎到鼎鼎大名的「淡水老街」，在街道兩旁林立熱鬧的商店，包含有濃濃古早味的米行、餅舖、布店、雜貨店等；以及充滿現代感的潮流服飾、玩具等，形成古今交融的特殊商圈文化。老街裡可以尋寶、品嚐美食，還有古蹟可參觀，怎麼玩都不會膩，是遊人必去的超人氣景點。老街分成外側靠淡水河岸的部分(金色水岸步道)與內側的老街，著名在地特產包括古早味現烤蛋糕、阿給、烤魷魚、阿婆鐵蛋、魚酥、巨無霸冰淇淋、魚丸等等，都是來老街非吃不可的美食。 ",

                    "獨特尖拱造型建於1882年的大禮拜堂樓層分地下三層、地上四層、屋突三層，合計十層。 建築方面為了突顯基督教教義風格，重複使用象徵「虛心祈禱的手」的尖拱造型，無論在主體建築、窗戶和大門，皆塑造出建築的獨特風格。\n建造於斜坡上，氣勢恢宏，現在已成為婚攝熱門地的大禮拜堂。",
            "獨特尖拱造型建於1882年的大禮拜堂樓層分地下三層、地上四層、屋突三層，合計十層。 建築方面為了突顯基督教教義風格，重複使用象徵「虛心祈禱的手」的尖拱造型，無論在主體建築、窗戶和大門，皆塑造出建築的獨特風格。\n建造於斜坡上，氣勢恢宏，現在已成為婚攝熱門地的大禮拜堂。",

            "紅毛城（閩南語：Âng-mn ̂ g-siânn），舊稱安東尼堡，是一座位於新北市淡水區的古蹟。 最早建城是在1628年統治北部的西班牙人所興建的“聖多明哥城”，但後來聖多明哥城遭到摧毀，1644年荷蘭人於聖多明哥城原址附近予以重建，並命名為“安東尼堡”。 而由於當時稱呼荷蘭人為紅毛，囙此這個城就被他們稱作紅毛城。\n 1724年，臺灣開始整修紅毛城，增辟了四座週邊城門。1867年以後，紅毛城開始由英國政府租用，作為領事館，並於其旁興建領事官邸。太平洋戰爭期間，日本向英美宣戰，並曾短暫查封紅毛城，但於戰後即被交還與英方。爾後，依序由澳大利亞與美國代為管理。一直到1980年，該城被指定為一級古蹟並開放供群眾參觀。紅毛城被視為臺灣現存最古老的建築之一。 ",
            "紅毛城（閩南語：Âng-mn ̂ g-siânn），舊稱安東尼堡，是一座位於新北市淡水區的古蹟。 最早建城是在1628年統治北部的西班牙人所興建的“聖多明哥城”，但後來聖多明哥城遭到摧毀，1644年荷蘭人於聖多明哥城原址附近予以重建，並命名為“安東尼堡”。 而由於當時稱呼荷蘭人為紅毛，囙此這個城就被他們稱作紅毛城。\n 1724年，臺灣開始整修紅毛城，增辟了四座週邊城門。1867年以後，紅毛城開始由英國政府租用，作為領事館，並於其旁興建領事官邸。太平洋戰爭期間，日本向英美宣戰，並曾短暫查封紅毛城，但於戰後即被交還與英方。爾後，依序由澳大利亞與美國代為管理。一直到1980年，該城被指定為一級古蹟並開放供群眾參觀。紅毛城被視為臺灣現存最古老的建築之一。 ",



            "漁人碼頭位於淡水河出海口右岸，舊名淡水第二漁港，以夕陽餘暉著稱。除了賞夕陽之外，必走招牌地標情人橋、搭渡輪走藍色公路或沿著原木棧道賞漁港風景，亦可登上情人塔將淡水景緻一覽無遺。； 行政院農業委員會為改善漁港工作與漁村生活環境，自1998年起選定此處為多功能示範漁港，大力補助經費，並且將於漁人碼頭規劃成為一個兼具漁業發展與觀光休閒的優質公園，成功的朝漁港功能多元化方向發展，漁人碼頭經過整地興建，成為重要的觀光活動休閒的場地，漁人碼頭邊停滿了許多漁船及遊輪，更常成為廣告片拍攝的場景。\n",
            "漁人碼頭位於淡水河出海口右岸，舊名淡水第二漁港，以夕陽餘暉著稱。除了賞夕陽之外，必走招牌地標情人橋、搭渡輪走藍色公路或沿著原木棧道賞漁港風景，亦可登上情人塔將淡水景緻一覽無遺。； 行政院農業委員會為改善漁港工作與漁村生活環境，自1998年起選定此處為多功能示範漁港，大力補助經費，並且將於漁人碼頭規劃成為一個兼具漁業發展與觀光休閒的優質公園，成功的朝漁港功能多元化方向發展，漁人碼頭經過整地興建，成為重要的觀光活動休閒的場地，漁人碼頭邊停滿了許多漁船及遊輪，更常成為廣告片拍攝的場景。\n",


            "情人橋，全長165公尺，以流線的單面斜張橋橫跨港區，白色風帆造型奪人眼目，連接木棧道與觀光漁市。每逢傍晚時分，便能看到大批的人潮在此等待，捕捉夕陽沉入海洋的美麗景色。當夜晚來臨時，白色的橋面在燈光的照射下，更顯多彩繽紛，也是來淡水必賞的夜景之一。\n傳說中，相戀的情侶在走完這座橋後，若真的沒有緣分，不久將會分手。" +
                    "另一說法是在橋墩的燈光轉換至綠色時，千萬不能相互直視，否則將逃不了分手魔咒。\n" +
                    "說法眾說紛紜，為這座橋蒙上一層神秘的面紗，也因此吸引不少人來朝聖。",
            "情人橋，全長165公尺，以流線的單面斜張橋橫跨港區，白色風帆造型奪人眼目，連接木棧道與觀光漁市。每逢傍晚時分，便能看到大批的人潮在此等待，捕捉夕陽沉入海洋的美麗景色。當夜晚來臨時，白色的橋面在燈光的照射下，更顯多彩繽紛，也是來淡水必賞的夜景之一。\n傳說中，相戀的情侶在走完這座橋後，若真的沒有緣分，不久將會分手。" +
                    "另一說法是在橋墩的燈光轉換至綠色時，千萬不能相互直視，否則將逃不了分手魔咒。\n" +
                    "說法眾說紛紜，為這座橋蒙上一層神秘的面紗，也因此吸引不少人來朝聖。",
    };


    public static String[] contsEn = {
            "Located on the riverbank behind Tamsui Post Office, this bronze statue was created by Mr. Chen Kai-huang from Taipei National University of the Arts. The design depicts the image of Mackay landing on shore, also known as the \"Mackay Art Bronze Statue.\" Dr. Mackay is shown kneeling on the ground with a Bible in his hands, praying, and beside him is the small boat he arrived in. Hence, the full name of this site is \"Mackay Landing Small Ark and Mackay Prayer Statue.\" On the afternoon of March 9, 1872, Canadian missionary Dr. Mackay landed here via the \"Sea Dragon\" ship, making Tamsui his base for missionary work, medical care, and education. He chose Tamsui as his home, where he married, raised a family, and was eventually buried.",
            "Located on the riverbank behind Tamsui Post Office, this bronze statue was created by Mr. Chen Kai-huang from Taipei National University of the Arts. The design depicts the image of Mackay landing on shore, also known as the \"Mackay Art Bronze Statue.\" Dr. Mackay is shown kneeling on the ground with a Bible in his hands, praying, and beside him is the small boat he arrived in. Hence, the full name of this site is \"Mackay Landing Small Ark and Mackay Prayer Statue.\" On the afternoon of March 9, 1872, Canadian missionary Dr. Mackay landed here via the \"Sea Dragon\" ship, making Tamsui his base for missionary work, medical care, and education. He chose Tamsui as his home, where he married, raised a family, and was eventually buried.",

            "George Leslie Mackay (March 21, 1844 – June 2, 1901) was born in Ontario, Canada. He was a pastor of the Canadian Presbyterian Mission and, although not a doctor, studied anatomy and physiology. He dedicated his life to Taiwan as a missionary. His Chinese name was Jie Ruili, but he was commonly known as \"Dr. Mackay.\" He came to Taiwan in the late 19th century to preach and practice medicine, earning a reputation alongside James Laidlaw Maxwell. Mackay's life was praised with the phrase, \"Rather burn out than rust out.\"",
            "George Leslie Mackay (March 21, 1844 – June 2, 1901) was born in Ontario, Canada. He was a pastor of the Canadian Presbyterian Mission and, although not a doctor, studied anatomy and physiology. He dedicated his life to Taiwan as a missionary. His Chinese name was Jie Ruili, but he was commonly known as \"Dr. Mackay.\" He came to Taiwan in the late 19th century to preach and practice medicine, earning a reputation alongside James Laidlaw Maxwell. Mackay's life was praised with the phrase, \"Rather burn out than rust out.\"",

            "The Oxford College, also known as the Mackay School, was the first Western-style school in Taiwan. Established in 1882 by Dr. Mackay, who raised funds in his hometown of Oxford County, Canada, it is located within Aletheia University. In 1985, it was designated as a Class II historic site by the Ministry of the Interior. Today, it serves as the university's history museum, showcasing historical and cultural materials related to the school and Mackay.",
            "The Oxford College, also known as the Mackay School, was the first Western-style school in Taiwan. Established in 1882 by Dr. Mackay, who raised funds in his hometown of Oxford County, Canada, it is located within Aletheia University. In 1985, it was designated as a Class II historic site by the Ministry of the Interior. Today, it serves as the university's history museum, showcasing historical and cultural materials related to the school and Mackay.",

            "Located between the Tamsui Golf Course and the Huwei Fort, the Cloud Gate Theatre overlooks Guanyin Mountain and the Tamsui River estuary. The light green glass curtain wall of the building reflects the surrounding tall trees and blends into the tranquil green landscape.\n" +
                    "Enter the indoor theater to watch performances and participate in shaping Cloud Gate’s new culture.",
            "Located between the Tamsui Golf Course and the Huwei Fort, the Cloud Gate Theatre overlooks Guanyin Mountain and the Tamsui River estuary. The light green glass curtain wall of the building reflects the surrounding tall trees and blends into the tranquil green landscape.\n" +
                    "Enter the indoor theater to watch performances and participate in shaping Cloud Gate’s new culture.",

            "Hobe Mackay Hospital is one of the historic sites in New Taipei City and the first Western-style hospital in Taiwan. Established on September 14, 1879, it was run by Dr. Mackay and also served as his residence.",
            "Hobe Mackay Hospital is one of the historic sites in New Taipei City and the first Western-style hospital in Taiwan. Established on September 14, 1879, it was run by Dr. Mackay and also served as his residence.",

            "The familiar Tamsui riverside is home to a beautifully named bike path called the \"Golden Waterfront.\" It stretches about 10 kilometers from the Zhonggang River entrance near Guandu Temple to Tamsui Old Street. This flat and easy-to-ride path is perfect for families to observe egrets and fiddler crabs while enjoying the ride. Arriving at the famous Tamsui Old Street, visitors can explore bustling shops offering traditional rice shops, pastry stores, cloth shops, and general stores, alongside modern fashion and toy stores, creating a unique blend of old and new. The street is divided into the outer riverside section (Golden Waterfront Walkway) and the inner old street. Famous local specialties include freshly baked cakes, agei (tofu stuffed with noodles), grilled squid, Grandma's Iron Eggs, fish crisps, giant ice cream, and fish balls, all must-try delicacies.",
            "The familiar Tamsui riverside is home to a beautifully named bike path called the \"Golden Waterfront.\" It stretches about 10 kilometers from the Zhonggang River entrance near Guandu Temple to Tamsui Old Street. This flat and easy-to-ride path is perfect for families to observe egrets and fiddler crabs while enjoying the ride. Arriving at the famous Tamsui Old Street, visitors can explore bustling shops offering traditional rice shops, pastry stores, cloth shops, and general stores, alongside modern fashion and toy stores, creating a unique blend of old and new. The street is divided into the outer riverside section (Golden Waterfront Walkway) and the inner old street. Famous local specialties include freshly baked cakes, agei (tofu stuffed with noodles), grilled squid, Grandma's Iron Eggs, fish crisps, giant ice cream, and fish balls, all must-try delicacies.",

            "The unique pointed-arch style chapel, built in 1882, consists of three underground floors, four above-ground floors, and three rooftop floors, totaling ten levels. To highlight Christian teachings, the design repeatedly uses the pointed arch, symbolizing \"hands in humble prayer,\" in the main structure, windows, and doors, creating a distinctive architectural style.\n" +
                    "Built on a slope, the grand chapel has become a popular spot for wedding photography.",
            "The unique pointed-arch style chapel, built in 1882, consists of three underground floors, four above-ground floors, and three rooftop floors, totaling ten levels. To highlight Christian teachings, the design repeatedly uses the pointed arch, symbolizing \"hands in humble prayer,\" in the main structure, windows, and doors, creating a distinctive architectural style.\n" +
                    "Built on a slope, the grand chapel has become a popular spot for wedding photography.",

            "Fort San Domingo (Hokkien: Âng-mn̂g-siânn), formerly known as Fort Antonio, is a historic site in Tamsui District, New Taipei City. Originally built in 1628 by the Spanish who ruled northern Taiwan as \"Fort Santo Domingo,\" it was later destroyed. In 1644, the Dutch rebuilt it near the original site and named it \"Fort Antonio.\" Since the Dutch were referred to as \"Red-Haired\" people, the fort became known as \"Fort San Domingo.\"\n" +
                    "In 1724, Taiwan began renovating the fort, adding four surrounding gates. After 1867, the British government leased it as a consulate and built a residence nearby. During the Pacific War, Japan declared war on the UK and the US, briefly seizing the fort, but it was returned to the British after the war. Later, it was managed by Australia and the US. In 1980, it was designated as a Class I historic site and opened to the public. Fort San Domingo is considered one of the oldest surviving buildings in Taiwan.",
            "Fort San Domingo (Hokkien: Âng-mn̂g-siânn), formerly known as Fort Antonio, is a historic site in Tamsui District, New Taipei City. Originally built in 1628 by the Spanish who ruled northern Taiwan as \"Fort Santo Domingo,\" it was later destroyed. In 1644, the Dutch rebuilt it near the original site and named it \"Fort Antonio.\" Since the Dutch were referred to as \"Red-Haired\" people, the fort became known as \"Fort San Domingo.\"\n" +
                    "In 1724, Taiwan began renovating the fort, adding four surrounding gates. After 1867, the British government leased it as a consulate and built a residence nearby. During the Pacific War, Japan declared war on the UK and the US, briefly seizing the fort, but it was returned to the British after the war. Later, it was managed by Australia and the US. In 1980, it was designated as a Class I historic site and opened to the public. Fort San Domingo is considered one of the oldest surviving buildings in Taiwan.",

            "Fisherman's Wharf, located on the right bank of the Tamsui River estuary, is famous for its sunset views. In addition to watching the sunset, visitors can walk across the iconic Lover's Bridge, take a ferry along the Blue Highway, or stroll along the wooden boardwalk to enjoy the harbor scenery. They can also ascend the Lover's Tower for a panoramic view of Tamsui.\n" +
                    "Since 1998, the Council of Agriculture has designated this area as a multifunctional demonstration fishing port, providing substantial funding to develop it into a high-quality park combining fishery development and tourism. Fisherman's Wharf has become an important venue for leisure activities, often serving as a filming location for advertisements.",
            "Fisherman's Wharf, located on the right bank of the Tamsui River estuary, is famous for its sunset views. In addition to watching the sunset, visitors can walk across the iconic Lover's Bridge, take a ferry along the Blue Highway, or stroll along the wooden boardwalk to enjoy the harbor scenery. They can also ascend the Lover's Tower for a panoramic view of Tamsui.\n" +
                    "Since 1998, the Council of Agriculture has designated this area as a multifunctional demonstration fishing port, providing substantial funding to develop it into a high-quality park combining fishery development and tourism. Fisherman's Wharf has become an important venue for leisure activities, often serving as a filming location for advertisements.",

            "Lover's Bridge, spanning 165 meters, is a sleek single-sided cable-stayed bridge crossing the harbor. Its white sail-like design is eye-catching, connecting the wooden boardwalk and the tourist fish market. Every evening, crowds gather here to capture the stunning sunset over the ocean. At night, the bridge's white surface, illuminated by lights, becomes even more colorful, making it a must-see nighttime attraction in Tamsui.\n" +
                    "Legend has it that couples who walk across the bridge and are not truly destined to be together will soon break up. Another version says that when the bridge's lights turn green, couples must not look directly at each other, or they will fall victim to the breakup curse.\n" +
                    "These tales add a layer of mystery to the bridge, attracting many visitors to experience it.",
            "Lover's Bridge, spanning 165 meters, is a sleek single-sided cable-stayed bridge crossing the harbor. Its white sail-like design is eye-catching, connecting the wooden boardwalk and the tourist fish market. Every evening, crowds gather here to capture the stunning sunset over the ocean. At night, the bridge's white surface, illuminated by lights, becomes even more colorful, making it a must-see nighttime attraction in Tamsui.\n" +
                    "Legend has it that couples who walk across the bridge and are not truly destined to be together will soon break up. Another version says that when the bridge's lights turn green, couples must not look directly at each other, or they will fall victim to the breakup curse.\n" +
                    "These tales add a layer of mystery to the bridge, attracting many visitors to experience it."
    };


    public static String[] contsKo = {
            "탐수이 우체국 뒤 강변에 위치한 이 동상은 타이페이 국립 예술대학의 천 카이황(陳愷璜) 선생이 제작한 작품으로, 매케이가 상륙하는 모습을 형상화한 동상이며, '매케이 예술 동상'이라고도 불립니다. 매케이 박사는 성경을 들고 땅에 무릎을 꿇고 기도하는 모습으로, 그의 곁에는 그가 타고 온 작은 배가 있습니다. 따라서 이 장소의 정식 명칭은 '매케이 상륙 작은 방주 및 매케이 기도 동상'입니다. 1872년 3월 9일 오후 3시, 캐나다 선교사 매케이 박사는 '해룡호'를 타고 이곳에 상륙했으며, 이후 탐수이를 선교, 의료, 교육의 중심지로 삼았습니다. 그는 탐수이를 집으로 삼아 여기서 결혼하고 가정을 이루었으며, 사후에도 이 땅에 묻혔습니다.",
            "탐수이 우체국 뒤 강변에 위치한 이 동상은 타이페이 국립 예술대학의 천 카이황(陳愷璜) 선생이 제작한 작품으로, 매케이가 상륙하는 모습을 형상화한 동상이며, '매케이 예술 동상'이라고도 불립니다. 매케이 박사는 성경을 들고 땅에 무릎을 꿇고 기도하는 모습으로, 그의 곁에는 그가 타고 온 작은 배가 있습니다. 따라서 이 장소의 정식 명칭은 '매케이 상륙 작은 방주 및 매케이 기도 동상'입니다. 1872년 3월 9일 오후 3시, 캐나다 선교사 매케이 박사는 '해룡호'를 타고 이곳에 상륙했으며, 이후 탐수이를 선교, 의료, 교육의 중심지로 삼았습니다. 그는 탐수이를 집으로 삼아 여기서 결혼하고 가정을 이루었으며, 사후에도 이 땅에 묻혔습니다.",

            "조지 레슬리 매케이(George Leslie Mackay, 1844년 3월 21일 ~ 1901년 6월 2일)는 캐나다 온타리오 주에서 태어났습니다. 그는 캐나다 장로교 선교회의 목사였으며, 의사는 아니었지만 해부학과 생리학을 공부했습니다. 그는 생을 대만에 바친 선교사였습니다. 그의 중국어 이름은 제이 루이리(偕睿理)였지만, 일반적으로 '매케이 박사'로 불렸습니다. 그는 19세기 말 대만에 와서 선교와 의료 활동을 펼쳤으며, 제임스 레이들로 맥스웰(James Laidlaw Maxwell)과 함께 명성을 얻었습니다. 매케이의 삶은 '녹슬어 없어지기보다는 타서 없어지겠다'라는 말로 칭송받았습니다.",
            "조지 레슬리 매케이(George Leslie Mackay, 1844년 3월 21일 ~ 1901년 6월 2일)는 캐나다 온타리오 주에서 태어났습니다. 그는 캐나다 장로교 선교회의 목사였으며, 의사는 아니었지만 해부학과 생리학을 공부했습니다. 그는 생을 대만에 바친 선교사였습니다. 그의 중국어 이름은 제이 루이리(偕睿理)였지만, 일반적으로 '매케이 박사'로 불렸습니다. 그는 19세기 말 대만에 와서 선교와 의료 활동을 펼쳤으며, 제임스 레이들로 맥스웰(James Laidlaw Maxwell)과 함께 명성을 얻었습니다. 매케이의 삶은 '녹슬어 없어지기보다는 타서 없어지겠다'라는 말로 칭송받았습니다.",

            "옥스퍼드 학당(理學堂大書院)은 대만 최초의 서양식 학교로, 1882년 매케이 박사가 고향인 캐나다 옥스퍼드 카운티에서 기금을 모아 설립했습니다. 이 학교는 현재 알레테이아 대학(真理大學) 내에 위치해 있으며, '옥스퍼드 학당'이라고도 불립니다. 1985년 내정부(內政部)에 의해 2급 고적으로 지정되었으며, 현재는 대학의 역사 박물관으로 사용되고 있습니다. 학교와 매케이 박사와 관련된 역사적 자료를 전시하고 있습니다.",
            "옥스퍼드 학당(理學堂大書院)은 대만 최초의 서양식 학교로, 1882년 매케이 박사가 고향인 캐나다 옥스퍼드 카운티에서 기금을 모아 설립했습니다. 이 학교는 현재 알레테이아 대학(真理大學) 내에 위치해 있으며, '옥스퍼드 학당'이라고도 불립니다. 1985년 내정부(內政部)에 의해 2급 고적으로 지정되었으며, 현재는 대학의 역사 박물관으로 사용되고 있습니다. 학교와 매케이 박사와 관련된 역사적 자료를 전시하고 있습니다.",

            "탐수이 골프장과 후웨이 요새 사이에 위치한 클라우드 게이트 극장은 관인산과 탐수이 강 하구를 내려다보고 있습니다. 건물의 밝은 녹색 유리 커튼월은 주변의 키 큰 나무들을 반사하여 고요한 푸른 풍경에 녹아듭니다.\n" +
                    "건물 내부에는 극장, 소극장, 사무실, 세트 공장, 무용수 라운지가 들어설 계획이며, 사람들이 빠르게 움직이고 독립적으로 작업할 수 있도록 서로 연결되어 있습니다. 중앙라디오텔레비전국 옥상을 개조한 플랫폼, 입구 복도에서부터 잔디밭으로 이어지는 넓은 계단에 이르기까지의 야외 부분은 한 번에 완성되었습니다. 사람들은 야외 공간을 거닐고, 실내 극장에 들어가 공연을 관람하고, 클라우드 게이트의 새로운 문화 형성에 참여했습니다.",
            "탐수이 골프장과 후웨이 요새 사이에 위치한 클라우드 게이트 극장은 관인산과 탐수이 강 하구를 내려다보고 있습니다. 건물의 밝은 녹색 유리 커튼월은 주변의 키 큰 나무들을 반사하여 고요한 푸른 풍경에 녹아듭니다.\n" +
                    "건물 내부에는 극장, 소극장, 사무실, 세트 공장, 무용수 라운지가 들어설 계획이며, 사람들이 빠르게 움직이고 독립적으로 작업할 수 있도록 서로 연결되어 있습니다. 중앙라디오텔레비전국 옥상을 개조한 플랫폼, 입구 복도에서부터 잔디밭으로 이어지는 넓은 계단에 이르기까지의 야외 부분은 한 번에 완성되었습니다. 사람들은 야외 공간을 거닐고, 실내 극장에 들어가 공연을 관람하고, 클라우드 게이트의 새로운 문화 형성에 참여했습니다.",

            "후베이 매케이 병원(滬尾偕醫館)은 신베이시(新北市)의 고적 중 하나로, 대만 최초의 서양식 병원입니다. 1879년 9월 14일 매케이 박사가 설립했으며, 그의 거주지로도 사용되었습니다.",
            "후베이 매케이 병원(滬尾偕醫館)은 신베이시(新北市)의 고적 중 하나로, 대만 최초의 서양식 병원입니다. 1879년 9월 14일 매케이 박사가 설립했으며, 그의 거주지로도 사용되었습니다.",

            "탐수이 강변에는 '골든 워터프론트(Golden Waterfront)'라는 아름다운 이름의 자전거 도로가 있습니다. 이 도로는 관두 사원(Guandu Temple) 근처의 중강 강 입구에서 탐수이 올드 스트리트까지 약 10킬로미터에 걸쳐 있습니다. 평평하고 쉽게 탈 수 있는 이 도로는 가족들이 백로와 꽃발게를 관찰하며 즐기기에 적합합니다. 유명한 탐수이 올드 스트리트에 도착하면, 전통 쌀 가게, 빵집, 천 가게, 잡화점 등과 현대적인 패션 매장, 장난감 가게가 어우러진 독특한 분위기를 느낄 수 있습니다. 올드 스트리트는 강변 부분(골든 워터프론트 산책로)과 내부 올드 스트리트로 나뉘며, 현지 특산품으로는 전통 빵, 아게이(아게), 오징어 구이, 할머니의 철계란, 생선 크리스프, 대형 아이스크림, 생선볼 등이 있습니다. 이곳은 반드시 맛봐야 할 음식들로 가득합니다.",
            "탐수이 강변에는 '골든 워터프론트(Golden Waterfront)'라는 아름다운 이름의 자전거 도로가 있습니다. 이 도로는 관두 사원(Guandu Temple) 근처의 중강 강 입구에서 탐수이 올드 스트리트까지 약 10킬로미터에 걸쳐 있습니다. 평평하고 쉽게 탈 수 있는 이 도로는 가족들이 백로와 꽃발게를 관찰하며 즐기기에 적합합니다. 유명한 탐수이 올드 스트리트에 도착하면, 전통 쌀 가게, 빵집, 천 가게, 잡화점 등과 현대적인 패션 매장, 장난감 가게가 어우러진 독특한 분위기를 느낄 수 있습니다. 올드 스트리트는 강변 부분(골든 워터프론트 산책로)과 내부 올드 스트리트로 나뉘며, 현지 특산품으로는 전통 빵, 아게이(아게), 오징어 구이, 할머니의 철계란, 생선 크리스프, 대형 아이스크림, 생선볼 등이 있습니다. 이곳은 반드시 맛봐야 할 음식들로 가득합니다.",

            "1882년에 지어진 독특한 첨탑 형태의 예배당은 지하 3층, 지상 4층, 옥탑 3층으로 총 10층으로 구성되어 있습니다. 기독교 교리를 강조하기 위해, '겸손한 기도의 손'을 상징하는 첨탑 형태를 주 건물, 창문, 문 등에 반복적으로 사용하여 독특한 건축 스타일을 창조했습니다.\n" +
                    "경사진 곳에 지어진 이 웅장한 예배당은 현재 결혼 사진 촬영의 명소가 되었습니다.",
            "1882년에 지어진 독특한 첨탑 형태의 예배당은 지하 3층, 지상 4층, 옥탑 3층으로 총 10층으로 구성되어 있습니다. 기독교 교리를 강조하기 위해, '겸손한 기도의 손'을 상징하는 첨탑 형태를 주 건물, 창문, 문 등에 반복적으로 사용하여 독특한 건축 스타일을 창조했습니다.\n" +
                    "경사진 곳에 지어진 이 웅장한 예배당은 현재 결혼 사진 촬영의 명소가 되었습니다.",

            "홍모성(紅毛城, Hokkien: Âng-mn̂g-siânn)은 신베이시 탐수이 구에 위치한 고적입니다. 원래 1628년 북부 대만을 지배하던 스페인 사람들이 '산토 도밍고 성(Fort Santo Domingo)'으로 건축했으나, 이후 파괴되었습니다. 1644년 네덜란드 사람들이 원래 위치 근처에 재건축하여 '안토니오 성(Fort Antonio)'이라고 명명했습니다. 당시 네덜란드 사람들을 '홍모(紅毛, 붉은 머리)'라고 불렀기 때문에, 이 성은 '홍모성'으로 불리게 되었습니다.\n" +
                    "1724년 대만은 성을 수리하며 주변에 4개의 문을 추가했습니다. 1867년 이후 영국 정부가 이 성을 영사관으로 임대했으며, 근처에 영사관 저택을 지었습니다. 태평양 전쟁 중 일본이 영국과 미국에 선전포고를 하며 잠시 성을 압수했지만, 전쟁 후 영국에 반환되었습니다. 이후 호주와 미국이 순차적으로 관리를 맡았습니다. 1980년 이 성은 1급 고적으로 지정되어 대중에게 공개되었습니다. 홍모성은 대만에서 현존하는 가장 오래된 건축물 중 하나로 여겨집니다.",
            "홍모성(紅毛城, Hokkien: Âng-mn̂g-siânn)은 신베이시 탐수이 구에 위치한 고적입니다. 원래 1628년 북부 대만을 지배하던 스페인 사람들이 '산토 도밍고 성(Fort Santo Domingo)'으로 건축했으나, 이후 파괴되었습니다. 1644년 네덜란드 사람들이 원래 위치 근처에 재건축하여 '안토니오 성(Fort Antonio)'이라고 명명했습니다. 당시 네덜란드 사람들을 '홍모(紅毛, 붉은 머리)'라고 불렀기 때문에, 이 성은 '홍모성'으로 불리게 되었습니다.\n" +
                    "1724년 대만은 성을 수리하며 주변에 4개의 문을 추가했습니다. 1867년 이후 영국 정부가 이 성을 영사관으로 임대했으며, 근처에 영사관 저택을 지었습니다. 태평양 전쟁 중 일본이 영국과 미국에 선전포고를 하며 잠시 성을 압수했지만, 전쟁 후 영국에 반환되었습니다. 이후 호주와 미국이 순차적으로 관리를 맡았습니다. 1980년 이 성은 1급 고적으로 지정되어 대중에게 공개되었습니다. 홍모성은 대만에서 현존하는 가장 오래된 건축물 중 하나로 여겨집니다.",

            "어부의 부두(Fisherman's Wharf)는 탐수이 강 하구 오른쪽 강변에 위치해 있으며, 석양으로 유명합니다. 석양을 감상하는 것 외에도, 상징적인 러버스 브리지(Lover's Bridge)를 건너거나, 블루 하이웨이(Blue Highway)를 따라 페리를 타고, 나무 산책로를 따라 항구 풍경을 즐길 수 있습니다. 또한 러버스 타워(Lover's Tower)에 올라 탐수이의 전경을 조망할 수도 있습니다.\n" +
                    "1998년부터 농업위원회는 이곳을 다기능 시범 어항으로 지정하고, 어업 발전과 관광을 결합한 고품질 공원으로 개발하기 위해 상당한 자금을 지원했습니다. 어부의 부두는 중요한 관광 및 레저 활동 장소가 되었으며, 광고 촬영지로도 자주 사용됩니다.",
            "어부의 부두(Fisherman's Wharf)는 탐수이 강 하구 오른쪽 강변에 위치해 있으며, 석양으로 유명합니다. 석양을 감상하는 것 외에도, 상징적인 러버스 브리지(Lover's Bridge)를 건너거나, 블루 하이웨이(Blue Highway)를 따라 페리를 타고, 나무 산책로를 따라 항구 풍경을 즐길 수 있습니다. 또한 러버스 타워(Lover's Tower)에 올라 탐수이의 전경을 조망할 수도 있습니다.\n" +
                    "1998년부터 농업위원회는 이곳을 다기능 시범 어항으로 지정하고, 어업 발전과 관광을 결합한 고품질 공원으로 개발하기 위해 상당한 자금을 지원했습니다. 어부의 부두는 중요한 관광 및 레저 활동 장소가 되었으며, 광고 촬영지로도 자주 사용됩니다.",

            "러버스 브리지(Lover's Bridge)는 길이 165미터로, 항구를 가로지르는 세련된 단면 케이블-스테이 브리지입니다. 흰색 돛 모양의 디자인이 눈길을 끌며, 나무 산책로와 관광 어시장을 연결합니다. 매일 저녁, 많은 사람들이 이곳에 모여 바다로 지는 석양의 아름다운 풍경을 담습니다. 밤에는 조명으로 비춰진 흰색 다리 표면이 더욱 화려해져, 탐수이의 필수 야경 명소가 되었습니다.\n" +
                    "전설에 따르면, 이 다리를 건너고도 진정으로 운명이 아닌 커플은 곧 헤어지게 된다고 합니다. 또 다른 전설은 다리의 조명이 초록색으로 바뀔 때 서로를 똑바로 쳐다보면 헤어지는 저주에 걸린다는 것입니다.\n" +
                    "이러한 이야기들은 다리에 신비로운 분위기를 더하며, 많은 방문객들이 이곳을 찾게 합니다.",
            "러버스 브리지(Lover's Bridge)는 길이 165미터로, 항구를 가로지르는 세련된 단면 케이블-스테이 브리지입니다. 흰색 돛 모양의 디자인이 눈길을 끌며, 나무 산책로와 관광 어시장을 연결합니다. 매일 저녁, 많은 사람들이 이곳에 모여 바다로 지는 석양의 아름다운 풍경을 담습니다. 밤에는 조명으로 비춰진 흰색 다리 표면이 더욱 화려해져, 탐수이의 필수 야경 명소가 되었습니다.\n" +
                    "전설에 따르면, 이 다리를 건너고도 진정으로 운명이 아닌 커플은 곧 헤어지게 된다고 합니다. 또 다른 전설은 다리의 조명이 초록색으로 바뀔 때 서로를 똑바로 쳐다보면 헤어지는 저주에 걸린다는 것입니다.\n" +
                    "이러한 이야기들은 다리에 신비로운 분위기를 더하며, 많은 방문객들이 이곳을 찾게 합니다."
    };


    public static String[] contsJa = {
            "淡水郵局の後ろの川岸にあるこの銅像は、国立台北藝術大学の陳愷璜氏によって制作されました。銅像はマッケイが上陸するイメージをデザインしており、「マッケイ芸術銅像」とも呼ばれています。マッケイ博士は聖書を手に地面に跪いて祈り、その傍らには彼が乗ってきた小船があります。そのため、この場所の正式名称は「マッケイ上陸の小箱舟とマッケイ祈りの像」です。1872年3月9日の午後3時、カナダの宣教師マッケイ博士は「海龍号」でここに上陸し、淡水を宣教、医療、教育の拠点としました。彼は淡水を家とし、ここで結婚し、家族を持ち、亡くなった後もこの地に埋葬されました。",
            "淡水郵局の後ろの川岸にあるこの銅像は、国立台北藝術大学の陳愷璜氏によって制作されました。銅像はマッケイが上陸するイメージをデザインしており、「マッケイ芸術銅像」とも呼ばれています。マッケイ博士は聖書を手に地面に跪いて祈り、その傍らには彼が乗ってきた小船があります。そのため、この場所の正式名称は「マッケイ上陸の小箱舟とマッケイ祈りの像」です。1872年3月9日の午後3時、カナダの宣教師マッケイ博士は「海龍号」でここに上陸し、淡水を宣教、医療、教育の拠点としました。彼は淡水を家とし、ここで結婚し、家族を持ち、亡くなった後もこの地に埋葬されました。",

            "ジョージ・レスリー・マッケイ（George Leslie Mackay、1844年3月21日 - 1901年6月2日）は、カナダのオンタリオ州で生まれました。カナダ長老教会の宣教師であり、医師ではありませんでしたが、解剖学と生理学を学びました。彼は生涯を台湾に捧げた宣教師でした。中国語名は「偕睿理」ですが、一般的には「マッケイ博士」と呼ばれています。19世紀末に台湾に来て、宣教と医療活動を行い、ジェームズ・レイドロー・マクスウェル（James Laidlaw Maxwell）と並ぶ名声を得ました。マッケイの人生は「錆びるより燃え尽きることを選ぶ」という言葉で称賛されています。",
            "ジョージ・レスリー・マッケイ（George Leslie Mackay、1844年3月21日 - 1901年6月2日）は、カナダのオンタリオ州で生まれました。カナダ長老教会の宣教師であり、医師ではありませんでしたが、解剖学と生理学を学びました。彼は生涯を台湾に捧げた宣教師でした。中国語名は「偕睿理」ですが、一般的には「マッケイ博士」と呼ばれています。19世紀末に台湾に来て、宣教と医療活動を行い、ジェームズ・レイドロー・マクスウェル（James Laidlaw Maxwell）と並ぶ名声を得ました。マッケイの人生は「錆びるより燃え尽きることを選ぶ」という言葉で称賛されています。",

            "理学堂大書院は、台湾で最初の西洋式学校です。1882年にマッケイ博士が故郷のカナダ・オックスフォード郡で資金を調達して設立し、真理大学内に位置しています。「オックスフォード学堂」とも呼ばれ、1985年に内政部によって二級古跡に指定されました。現在は真理大学の歴史博物館として、学校とマッケイ博士に関連する歴史資料を展示しています。",
            "理学堂大書院は、台湾で最初の西洋式学校です。1882年にマッケイ博士が故郷のカナダ・オックスフォード郡で資金を調達して設立し、真理大学内に位置しています。「オックスフォード学堂」とも呼ばれ、1985年に内政部によって二級古跡に指定されました。現在は真理大学の歴史博物館として、学校とマッケイ博士に関連する歴史資料を展示しています。",

            "淡水ゴルフコースと虎尾砲台の間に位置するクラウド ゲート シアターからは、観音山と淡水河の河口を見渡すことができます。建物の明るい緑色のガラスカーテンウォールは周囲の高い木々を映し出し、静かな緑の風景に溶け込んでいます。\n" +
                    "建物の内部には、劇場、小劇場、オフィススペース、セット工場、ダンサーラウンジなどが設けられ、それらが相互に連携し、人が素早く移動して独立して作業できるような設計となっている。エントランス廊下から中央ラジオテレビ局の屋上を改造したプラットフォーム、芝生へと続く幅広の階段まで屋外部分が一気に完成。人々は屋外スペースを散歩し、屋内劇場に入ってパフォーマンスを鑑賞し、クラウド・ゲートの新しい文化の形成に参加しました。",
            "淡水ゴルフコースと虎尾砲台の間に位置するクラウド ゲート シアターからは、観音山と淡水河の河口を見渡すことができます。建物の明るい緑色のガラスカーテンウォールは周囲の高い木々を映し出し、静かな緑の風景に溶け込んでいます。\n" +
                    "建物の内部には、劇場、小劇場、オフィススペース、セット工場、ダンサーラウンジなどが設けられ、それらが相互に連携し、人が素早く移動して独立して作業できるような設計となっている。エントランス廊下から中央ラジオテレビ局の屋上を改造したプラットフォーム、芝生へと続く幅広の階段まで屋外部分が一気に完成。人々は屋外スペースを散歩し、屋内劇場に入ってパフォーマンスを鑑賞し、クラウド・ゲートの新しい文化の形成に参加しました。",

            "滬尾偕医館は、新北市の古跡の一つで、台湾初の西洋式病院です。1879年9月14日にマッケイ博士によって設立され、彼の住居としても使用されました。",
            "滬尾偕医館は、新北市の古跡の一つで、台湾初の西洋式病院です。1879年9月14日にマッケイ博士によって設立され、彼の住居としても使用されました。",

            "淡水川岸には、「ゴールデン・ウォーターフロント」という美しい名前の自転車道があります。この道は、関渡宮近くの中港川入口から淡水老街まで約10キロメートルにわたって続いています。平坦で走りやすいこの道は、家族で白鷺やシオマネキを観察しながら楽しむのに最適です。有名な淡水老街に到着すると、伝統的な米屋、パン屋、布屋、雑貨店などと、現代的なファッションショップや玩具店が混在する独特の雰囲気を感じることができます。老街は川側の部分（ゴールデン・ウォーターフロント遊歩道）と内側の老街に分かれており、地元の特産品として、伝統的な焼き菓子、阿給（アゲ）、イカ焼き、阿婆鉄蛋（アポ・ティエダン）、魚酥（ユースー）、巨大アイスクリーム、魚団子などがあります。これらは老街で必ず食べるべきグルメです。",
            "淡水川岸には、「ゴールデン・ウォーターフロント」という美しい名前の自転車道があります。この道は、関渡宮近くの中港川入口から淡水老街まで約10キロメートルにわたって続いています。平坦で走りやすいこの道は、家族で白鷺やシオマネキを観察しながら楽しむのに最適です。有名な淡水老街に到着すると、伝統的な米屋、パン屋、布屋、雑貨店などと、現代的なファッションショップや玩具店が混在する独特の雰囲気を感じることができます。老街は川側の部分（ゴールデン・ウォーターフロント遊歩道）と内側の老街に分かれており、地元の特産品として、伝統的な焼き菓子、阿給（アゲ）、イカ焼き、阿婆鉄蛋（アポ・ティエダン）、魚酥（ユースー）、巨大アイスクリーム、魚団子などがあります。これらは老街で必ず食べるべきグルメです。",

            "1882年に建てられた独特の尖塔型の礼拝堂は、地下3階、地上4階、屋上3階の合計10階で構成されています。キリスト教の教えを強調するため、「謙虚な祈りの手」を象徴する尖塔型を主な建物、窓、ドアなどに繰り返し使用し、独特の建築スタイルを創造しました。\n" +
                    "斜面に建てられたこの壮大な礼拝堂は、現在結婚写真の撮影スポットとして人気です。",
            "1882年に建てられた独特の尖塔型の礼拝堂は、地下3階、地上4階、屋上3階の合計10階で構成されています。キリスト教の教えを強調するため、「謙虚な祈りの手」を象徴する尖塔型を主な建物、窓、ドアなどに繰り返し使用し、独特の建築スタイルを創造しました。\n" +
                    "斜面に建てられたこの壮大な礼拝堂は、現在結婚写真の撮影スポットとして人気です。",

            "紅毛城（閩南語：Âng-mn̂g-siânn）は、新北市淡水区にある古跡です。最初に城が建てられたのは1628年で、北部台湾を支配していたスペイン人によって「サント・ドミンゴ城」として建設されましたが、後に破壊されました。1644年、オランダ人がサント・ドミンゴ城の元の場所近くに再建し、「アントニオ城」と名付けました。当時、オランダ人は「紅毛（赤毛）」と呼ばれていたため、この城は「紅毛城」と呼ばれるようになりました。\n" +
                    "1724年、台湾は城を修復し、周囲に4つの門を追加しました。1867年以降、イギリス政府がこの城を領事館として借り受け、近くに領事館邸を建てました。太平洋戦争中、日本がイギリスとアメリカに宣戦布告し、一時的に城を差し押さえましたが、戦後イギリスに返還されました。その後、オーストラリアとアメリカが順番に管理しました。1980年、この城は一級古跡に指定され、一般公開されました。紅毛城は台湾に現存する最古の建築物の一つとされています。",
            "紅毛城（閩南語：Âng-mn̂g-siânn）は、新北市淡水区にある古跡です。最初に城が建てられたのは1628年で、北部台湾を支配していたスペイン人によって「サント・ドミンゴ城」として建設されましたが、後に破壊されました。1644年、オランダ人がサント・ドミンゴ城の元の場所近くに再建し、「アントニオ城」と名付けました。当時、オランダ人は「紅毛（赤毛）」と呼ばれていたため、この城は「紅毛城」と呼ばれるようになりました。\n" +
                    "1724年、台湾は城を修復し、周囲に4つの門を追加しました。1867年以降、イギリス政府がこの城を領事館として借り受け、近くに領事館邸を建てました。太平洋戦争中、日本がイギリスとアメリカに宣戦布告し、一時的に城を差し押さえましたが、戦後イギリスに返還されました。その後、オーストラリアとアメリカが順番に管理しました。1980年、この城は一級古跡に指定され、一般公開されました。紅毛城は台湾に現存する最古の建築物の一つとされています。",

            "漁人碼頭は淡水川の河口右岸に位置し、夕日で有名です。夕日を眺めるだけでなく、象徴的なラバーズ・ブリッジ（Lover's Bridge）を渡ったり、ブルー・ハイウェイ（Blue Highway）に沿ってフェリーに乗ったり、木製の遊歩道を散策して港の景色を楽しむことができます。また、ラバーズ・タワー（Lover's Tower）に登って淡水の全景を一望することもできます。\n" +
                    "1998年から、行政院農業委員会はこの場所を多機能デモンストレーション漁港に指定し、漁業発展と観光を組み合わせた高品質な公園として開発するために多額の資金を提供しました。漁人碼頭は重要な観光・レジャー活動の場となり、広告の撮影地としても頻繁に使用されています。",
            "漁人碼頭は淡水川の河口右岸に位置し、夕日で有名です。夕日を眺めるだけでなく、象徴的なラバーズ・ブリッジ（Lover's Bridge）を渡ったり、ブルー・ハイウェイ（Blue Highway）に沿ってフェリーに乗ったり、木製の遊歩道を散策して港の景色を楽しむことができます。また、ラバーズ・タワー（Lover's Tower）に登って淡水の全景を一望することもできます。\n" +
                    "1998年から、行政院農業委員会はこの場所を多機能デモンストレーション漁港に指定し、漁業発展と観光を組み合わせた高品質な公園として開発するために多額の資金を提供しました。漁人碼頭は重要な観光・レジャー活動の場となり、広告の撮影地としても頻繁に使用されています。",

            "ラバーズ・ブリッジ（Lover's Bridge）は全長165メートルで、港を横断する流線型のシングル・ケーブル・ステイ・ブリッジです。白い帆のデザインが目を引き、木製の遊歩道と観光魚市場を結んでいます。毎晩、多くの人々がここに集まり、海に沈む夕日の美しい景色を撮影します。夜になると、ライトアップされた白い橋の表面がさらにカラフルになり、淡水の必須夜景スポットとなっています。\n" +
                    "伝説によると、この橋を渡った後に本当に運命でないカップルは、すぐに別れると言われています。また、橋のライトが緑色に変わった時に互いを見つめ合うと、別れる呪いにかかるとも言われています。\n" +
                    "これらの話は橋に神秘的な雰囲気を加え、多くの人々が訪れる理由となっています。",
            "ラバーズ・ブリッジ（Lover's Bridge）は全長165メートルで、港を横断する流線型のシングル・ケーブル・ステイ・ブリッジです。白い帆のデザインが目を引き、木製の遊歩道と観光魚市場を結んでいます。毎晩、多くの人々がここに集まり、海に沈む夕日の美しい景色を撮影します。夜になると、ライトアップされた白い橋の表面がさらにカラフルになり、淡水の必須夜景スポットとなっています。\n" +
                    "伝説によると、この橋を渡った後に本当に運命でないカップルは、すぐに別れると言われています。また、橋のライトが緑色に変わった時に互いを見つめ合うと、別れる呪いにかかるとも言われています。\n" +
                    "これらの話は橋に神秘的な雰囲気を加え、多くの人々が訪れる理由となっています。"
    };

    //網址詳情
    public static String[] url = {
            "http://tamsui.dils.tku.edu.tw/wiki/index.php/%E9%A6%AC%E5%81%95%E8%97%9D%E8%A1%93%E9%8A%85%E5%83%8F",
            "http://tamsui.dils.tku.edu.tw/wiki/index.php/%E9%A6%AC%E5%81%95%E8%97%9D%E8%A1%93%E9%8A%85%E5%83%8F",

            "https://zh.wikipedia.org/zh-tw/%E9%A6%AC%E5%81%95#%E9%A6%AC%E5%81%95%E4%BE%86%E8%87%BA%E5%88%9D%E6%9C%9F%EF%BC%881871%E5%B9%B412%E6%9C%8830%E6%97%A5-1880%E5%B9%B412%E6%9C%8831%E6%97%A5%EF%BC%89",
            "https://zh.wikipedia.org/zh-tw/%E9%A6%AC%E5%81%95#%E9%A6%AC%E5%81%95%E4%BE%86%E8%87%BA%E5%88%9D%E6%9C%9F%EF%BC%881871%E5%B9%B412%E6%9C%8830%E6%97%A5-1880%E5%B9%B412%E6%9C%8831%E6%97%A5%EF%BC%89",

            "https://zh.wikipedia.org/zh-tw/%E7%89%9B%E6%B4%A5%E5%AD%B8%E5%A0%82",
            "https://zh.wikipedia.org/zh-tw/%E7%89%9B%E6%B4%A5%E5%AD%B8%E5%A0%82",


            "https://www.starbucks.com.tw/stores/special/stores_special_zhongzheng-tamsui.jspx",
            "https://www.starbucks.com.tw/stores/special/stores_special_zhongzheng-tamsui.jspx",


            "https://newtaipei.travel/zh-tw/attractions/detail/110411",
            "https://newtaipei.travel/zh-tw/attractions/detail/110411",


            "https://newtaipei.travel/zh-tw/attractions/detail/209657",
            "https://newtaipei.travel/zh-tw/attractions/detail/209657",


            "https://newtaipei.travel/zh-tw/attractions/detail/402706",
            "https://newtaipei.travel/zh-tw/attractions/detail/402706",

            "https://newtaipei.travel/zh-tw/attractions/detail/109672",
            "https://newtaipei.travel/zh-tw/attractions/detail/109672",


            "https://www.travel.taipei/zh-tw/attraction/details/120",
            "https://www.travel.taipei/zh-tw/attraction/details/120",


            "https://newtaipei.travel/zh-tw/attractions/detail/403143",
            "https://newtaipei.travel/zh-tw/attractions/detail/403143",
    };
    //城市
    public static String[] city = {
            "新北市",
            "新北市",

            "新北市",
            "新北市",

            "新北市",
            "新北市",


            "新北市",
            "新北市",


            "新北市",
            "新北市",


            "新北市",
            "新北市",


            "新北市",
            "新北市",

            "新北市",
            "新北市",


            "新北市",
            "新北市",


            "新北市",
            "新北市",
    };
    //詳細地址
    public static String[] address = new String[]{
            " 新北市淡水區中正路15巷 ",
            " 新北市淡水區中正路15巷 ",

            " 新北市淡水區中正路-馬偕銅像三角公園",
            " 新北市淡水區中正路-馬偕銅像三角公園",

            " 新北市淡水區真理街32號  ",
            " 新北市淡水區真理街32號  ",


            " 新北市淡水區中正路一段6巷32-1號 ",
            " 新北市淡水區中正路一段6巷32-1號 ",


            " 新北市淡水區馬偕街6號  ",
            " 新北市淡水區馬偕街6號  ",


            " 新北市淡水區環河道路 ",
            " 新北市淡水區環河道路 ",


            " 新北市淡水區真理街32號 ",
            " 新北市淡水區真理街32號 ",

            " 新北市淡水區中正路28巷1號 ",
            " 新北市淡水區中正路28巷1號 ",


            " 新北市淡水區觀海路199號  ",
            " 新北市淡水區觀海路199號 ",


            " 新北市淡水區觀海路199號  ",
            " 新北市淡水區觀海路199號  ",
    };
    //經緯度
    public static double[][] dian = {
            {25.17525, 121.447486},
            {25.17525, 121.447486},

            {25.175145, 121.449296},
            {25.175145, 121.449296},

            {25.179786, 121.445046},
            {25.179786, 121.445046},

            {25.184501, 121.438852},
            {25.184501, 121.438852},

            {25.17556, 121.449111},
            {25.17556, 121.449111},

            {25.171581, 121.454296},
            {25.171581, 121.454296},

            {25.179062, 121.444596},
            {25.179062, 121.444596},

            {25.179, 121.444021},
            {25.179, 121.444021},

            {25.186505, 121.421321},
            {25.186505, 121.421321},

            {25.0738, 121.533861},
            {25.0738, 121.533861},


    };


}
