package com.weibo.weibo.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URLDecoder;
import java.net.URLEncoder;

@Slf4j
@SpringBootTest()
public class WeiboControllerTest {

    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @BeforeEach
    public void setup(){
        log.info("测试开始...");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void query() throws Exception{
        String keyword = "新冠";
        String keyword_utf8 = URLDecoder.decode(keyword, "UTF-8");
        String get_url = "/getWeibo/" + keyword_utf8 + "/1";
        log.info(get_url);
        MvcResult mvcResult = null;
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getWeibo/新冠/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        String answer = "[{\"pageCount\":\"44\"},{\"user_id\":\"2803301701\",\"screen_name\":\"人民日报\",\"bw_id\":\"4523722733846269\",\"topic\":\"#新冠病毒在亚洲出现前已在其他地方出现# #牛津大学称新冠病毒可能藏于世界各地# \",\"created_at\":\"2020-07-06\",\"id\":\"915\",\"reposts_count\":\"8352\",\"wd\":\"新冠\",\"content\":\"【牛津大学最新研究：#新冠病毒在亚洲出现前已在其他地方出现#】据《每日电讯报》，牛津大学循证医学中心（CEBM）高级副导师汤姆·杰弗逊博士认为，越来越多的证据表明新冠病毒在亚洲出现之前就已在其他地方出现。#牛津大学称新冠病毒可能藏于世界各地#，在特定环境下被激活，而非源自中国。（央视）http:\\/\\/t.cn\\/A6yGpIUm\"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4523944583764473\",\"topic\":\"#美国疫情# #美国得州883个托儿所发现新冠# \",\"created_at\":\"2020-07-07\",\"id\":\"912\",\"reposts_count\":\"2115\",\"wd\":\"新冠\",\"content\":\"#美国疫情# #美国得州883个托儿所发现新冠# 】当地时间7月6日，美国得州卫生与公共服务部报告，该州的托儿所内至少出现1335例新冠肺炎确诊病例，其中894例为工作人员，441例为儿童。该州目前已经开放的托儿所中883个已发现新冠病例。（央视记者殷岳） \"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4527007683155976\",\"topic\":\"#重庆冻南美白虾部分包装新冠阳性# \",\"created_at\":\"2020-07-15\",\"id\":\"520\",\"reposts_count\":\"2065\",\"wd\":\"新冠\",\"content\":\"【#重庆冻南美白虾部分包装新冠阳性#】据重庆沙坪坝区通报：近日，重庆沙坪坝区疫情防控工作领导小组对从厄瓜多尔进口的冻南美白虾进行了全面清查。7月14日，检测发现西部物流园一冷冻仓库部分产品外包装新冠病毒核酸呈阳性。区疫情防控工作领导小组第一时间对配送点、门店、消费者及相关接触人员进行全面排查，对物品进行封存，对接触人员进行隔离观察，并严格开展环境、物品和接触人员的核酸检测。同时加强对冷冻冷藏肉品的风险排查，切实保障食品安全。相关防控工作正按要求规范有序开展。（总台央视记者伍黎明）\"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4527321673374546\",\"topic\":\"#乌鲁木齐疫情# #新疆乌鲁木齐发现1例确诊病例# \",\"created_at\":\"2020-07-16\",\"id\":\"522\",\"reposts_count\":\"2754\",\"wd\":\"新冠\",\"content\":\"#乌鲁木齐疫情#【#新疆乌鲁木齐发现1例确诊病例# 无症状感染者3例】乌鲁木齐市新型冠状病毒肺炎疫情防控工作指挥部：7月15日，乌鲁木齐市天山区发现新冠肺炎确诊病例1例，无症状感染者3例（均在医学观察中）。主要情况通报如下：确诊病例，女，24岁，系中泉广场三楼营业厅工作人员，常住地为乌鲁木齐市天山区。7月10日，该病例因咽喉疼痛等症状，由120救护车运送至定点医院。该病例7月14日出现发热、头痛等症状，7月15日，核酸检测结果呈阳性，经专家诊断为确诊病例，临床分型为轻型。确诊病例感染原因正在调查中。经排查密切接触者发现无症状感染者3例，均与确诊病例有接触史。（总台央视记者苏蒙）\"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4527569159061524\",\"topic\":\"#美国部分疫情数据从疾控中心网站删除# \",\"created_at\":\"2020-07-17\",\"id\":\"55\",\"reposts_count\":\"1708\",\"wd\":\"新冠\",\"content\":\"【#美国部分疫情数据从疾控中心网站删除#】据CNN报道，当地时间16日，在特朗普政府决定“接管”新冠肺炎疫情数据后，美国疾控中心网站上的一些数据已被删除。《纽约时报》报道，美国政府要求全美医院从15日起，不再将疫情相关信息发送至疾控中心。不少专家担心疫情数据透明度下降，并加剧美国“疫情政治化”问题。（央视记者顾乡）\"},{\"user_id\":\"2803301701\",\"screen_name\":\"人民日报\",\"bw_id\":\"4527598803099508\",\"topic\":\"#黑龙江全部清零# \",\"created_at\":\"2020-07-17\",\"id\":\"525\",\"reposts_count\":\"1313\",\"wd\":\"新冠\",\"content\":\"【继续加油！ #黑龙江全部清零# 】据黑龙江省卫健委，2020年7月16日0-24时,黑龙江省无新发新冠肺炎疫情报告。以往确诊病例、无症状感染者、医学观察对象全部清零。 网页链接 \"},{\"user_id\":\"2803301701\",\"screen_name\":\"人民日报\",\"bw_id\":\"4527683415316521\",\"topic\":\"#新疆抗疫# #新疆新增新冠肺炎确诊5例# \",\"created_at\":\"2020-07-17\",\"id\":\"47\",\"reposts_count\":\"3843\",\"wd\":\"新冠\",\"content\":\"#新疆抗疫#【#新疆新增新冠肺炎确诊5例#，无症状感染者8例】新疆维吾尔自治区卫生健康委最新通报，7月16日0时至17日12时，新疆维吾尔自治区（含新疆生产建设兵团）报告新增新冠肺炎确诊病例5例、无症状感染者8例，为乌鲁木齐市病例。新增确诊病例和无症状感染者均为接受集中医学观察人员。截至7月17日12时，新疆（含兵团）现有确诊病例6例、无症状感染者11例，均在乌鲁木齐市，现有135人接受医学观察。\"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4527683897661881\",\"topic\":\"#新疆36小时内新增5例确诊病例# \",\"created_at\":\"2020-07-17\",\"id\":\"193\",\"reposts_count\":\"1319\",\"wd\":\"新冠\",\"content\":\"【#新疆36小时内新增5例确诊病例#】新疆维吾尔自治区卫生健康委最新通报，7月16日0时至17日12时，新疆维吾尔自治区（含新疆生产建设兵团）报告新增新冠肺炎确诊病例5例、无症状感染者8例。新增确诊病例和无症状感染者均为接受集中医学观察人员。截至7月17日12时，新疆（含兵团）现有确诊病例6例、无症状感染者11例，均在乌鲁木齐市。（总台央视记者刘菲 水政）\"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4527734929761396\",\"topic\":\"#华春莹无奈地笑了# #华春莹回应所谓中国想窃取美国疫苗# \",\"created_at\":\"2020-07-17\",\"id\":\"114\",\"reposts_count\":\"5406\",\"wd\":\"新冠\",\"content\":\"【#华春莹无奈地笑了#：我们需要靠偷？太荒谬了[笑cry]】今天，#华春莹回应所谓中国想窃取美国疫苗#时说：美方一些官员说“中国发动网络攻击”，想“窃取美国的疫苗”。太荒谬了！大家都知道，中国在新冠疫苗研发方面处于领先地位，我们有一流的科研人员，我们不需要去靠“偷”来取得领先地位。 http:\\/\\/t.cn\\/A6yY2EYz\"},{\"user_id\":\"2803301701\",\"screen_name\":\"人民日报\",\"bw_id\":\"4527776557698746\",\"topic\":\"#新疆抗疫# #新疆全面摸排核酸检测呈阳性者# \",\"created_at\":\"2020-07-17\",\"id\":\"152\",\"reposts_count\":\"843\",\"wd\":\"新冠\",\"content\":\"#新疆抗疫#【#新疆全面摸排核酸检测呈阳性者#】17日，新疆新冠肺炎疫情防控工作指挥部召开视频会议。会议强调，乌鲁木齐出现新增确诊病例和无症状感染者，再次印证了新冠肺炎疫情防控工作的复杂性。会议强调，有序开展核酸检测，做到应检尽检、愿检尽检。要严密开展大排查，把核酸检测呈阳性者、无症状感染者、密切接触者、直接接触者全面排摸出来，严格落实医学隔离措施，确保零遗漏、无死角。http:\\/\\/t.cn\\/A6yY6BLB\"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4527958708980214\",\"topic\":\"#新疆新增16例本土病例# #31省区市新增22例新冠肺炎# \",\"created_at\":\"2020-07-18\",\"id\":\"32\",\"reposts_count\":\"2982\",\"wd\":\"新冠\",\"content\":\"#新疆新增16例本土病例#【#31省区市新增22例新冠肺炎#】7月17日0—24时，31个省（自治区、直辖市）和新疆生产建设兵团报告新增确诊病例22例，其中境外输入病例6例（广东3例，山东2例，福建1例），本土病例16例（均在新疆）；无新增死亡病例；新增疑似病例1例，为本土病例（在新疆）。\\n  当日新增治愈出院病例21例，解除医学观察的密切接触者129人，重症病例与前一日持平。\\n  境外输入现有确诊病例84例（其中重症病例3例），现有疑似病例3例。累计确诊病例2004例，累计治愈出院病例1920例，无死亡病例。\\n  截至7月17日24时，据31个省（自治区、直辖市）和新疆生产建设兵团报告，现有确诊病例252例（其中重症病例3例），累计治愈出院病例78758例，累计死亡病例4634例，累计报告确诊病例83644例，现有疑似病例4例。累计追踪到密切接触者768470人，尚在医学观察的密切接触者4072人。\\n  31个省（自治区、直辖市）和新疆生产建设兵团报告新增无症状感染者14例（境外输入5例）；当日无转为确诊病例；当日解除医学观察9例（境外输入7例）；尚在医学观察无症状感染者109例（境外输入77例）。\\n  累计收到港澳台地区通报确诊病例2213例。其中，香港特别行政区1713例（出院1264例，死亡11例），澳门特别行政区46例（出院46例），台湾地区454例（出院440例，死亡7例）。\"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4528063897668846\",\"topic\":\"#江苏21人检验医疗队支援新疆# #共同战疫# \",\"created_at\":\"2020-07-18\",\"id\":\"466\",\"reposts_count\":\"1179\",\"wd\":\"新冠\",\"content\":\"【转起加油！ #江苏21人检验医疗队支援新疆# 】今天中午，根据新冠肺炎疫情防治工作需要，江苏省派出的21人检验医疗队，从南京禄口机场飞往新疆乌鲁木齐，支援新疆新冠肺炎筛查核酸检测工作。新疆加油！ #共同战疫# ！（总台央视记者吴睿 程守勤） \"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4528287813995060\",\"topic\":\"#美国11个州拒绝口罩令# #美国新冠肺炎超367万例# \",\"created_at\":\"2020-07-19\",\"id\":\"56\",\"reposts_count\":\"2285\",\"wd\":\"新冠\",\"content\":\"#美国11个州拒绝口罩令# 】目前， #美国新冠肺炎超367万例# 。美国大部分州和地方政府已要求民众在公共场所佩戴口罩。但仍有11个州对此存在争议。白宫内部文件显示，佐治亚州是新冠病毒“重灾区”，但该州州长与市长不断因口罩问题发生冲突……（央视记者顾乡） \"},{\"user_id\":\"2803301701\",\"screen_name\":\"人民日报\",\"bw_id\":\"4528311571058076\",\"topic\":\"#特朗普疫情言论翻车实录# \",\"created_at\":\"2020-07-19\",\"id\":\"100\",\"reposts_count\":\"1123\",\"wd\":\"新冠\",\"content\":\"#特朗普疫情言论翻车实录# 】17日，美媒发布一则视频，记录了美国新冠疫情发展至今特朗普涉疫情言论“翻车”的过程。美国是目前世界上受新冠疫情影响最严重的国家，截至美东时间18日下午6时36分，美国已有新冠病毒感染病例3697554例，其中包括死亡病例139948例。 微丢的微博视频 \"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4528317666166362\",\"topic\":\"#新疆新增13例本土病例# #新疆现有2705人接受医学观察# \",\"created_at\":\"2020-07-19\",\"id\":\"216\",\"reposts_count\":\"1586\",\"wd\":\"新冠\",\"content\":\"#新疆新增13例本土病例#【#新疆现有2705人接受医学观察#】新疆维吾尔自治区卫生健康委最新通报，7月18日12时至7月18日24时，新疆维吾尔自治区（含新疆生产建设兵团）报告新增新冠肺炎确诊病例13例，新增无症状感染者18例，均在乌鲁木齐市，全部为接受集中医学观察人员。截至7月18日24时，新疆（含兵团）现有确诊病例30例、无症状感染者41例，均在乌鲁木齐市，现有2705人接受医学观察。\"},{\"user_id\":\"2803301701\",\"screen_name\":\"人民日报\",\"bw_id\":\"4528402663219690\",\"topic\":\"#美疾控中心称纽约流行毒株与中国毫无关系# \",\"created_at\":\"2020-07-19\",\"id\":\"15\",\"reposts_count\":\"1583\",\"wd\":\"新冠\",\"content\":\"【#美疾控中心称纽约流行毒株与中国毫无关系#】据@CGTN ，美国疾控中心17日发布报告说，特朗普早在2月2日就匆忙发布对中国游客的入境禁令，可直到3月13日才宣布对欧洲国家实行入境限制，但到3月8日，新冠病毒早就开始在纽约市的社区传播。此外，报告还揭示了一个发现：纽约市流行的毒株与中国武汉毫不相干。纽约州长科莫针对该报告回应称，因为政府应对疫情失措，病毒传到了纽约市，导致这么多美国人丢掉了性命。\"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4528488150739620\",\"topic\":\"#乌鲁木齐两区升为高风险# \",\"created_at\":\"2020-07-19\",\"id\":\"196\",\"reposts_count\":\"1015\",\"wd\":\"新冠\",\"content\":\"【#乌鲁木齐两区升为高风险#】新疆维吾尔自治区新冠肺炎疫情防控工作指挥部发布关于动态调整各县（市、区）风险等级的公告。高风险地区：乌鲁木齐市天山区、沙依巴克区；中风险地区：乌鲁木齐经济技术开发区（头屯河区）、高新技术产业开发区（新市区）、水磨沟区；低风险地区：其他县（市、区）。（总台央视记者崔宁  钱重宇）\"},{\"user_id\":\"2803301701\",\"screen_name\":\"人民日报\",\"bw_id\":\"4528707336936334\",\"topic\":\"#新疆现有3016人接受医学观察# #新疆喀什地区新增1例确诊# #新疆新增本土病例17例详情# \",\"created_at\":\"2020-07-20\",\"id\":\"85\",\"reposts_count\":\"922\",\"wd\":\"新冠\",\"content\":\"【#新疆现有3016人接受医学观察#】新疆维吾尔自治区卫生健康委最新通报，7月19日0时至7月19日24时，新疆维吾尔自治区（含新疆生产建设兵团）报告新增新冠肺炎确诊病例17例。#新疆喀什地区新增1例确诊#其中，乌鲁木齐市16例、喀什地区1例（为乌鲁木齐市输入病例）；新增无症状感染者9例，均在乌鲁木齐市。#新疆新增本土病例17例详情#\\n     7月19日24时，新疆（含兵团）现有确诊病例47例(其中重症病例2例)，乌鲁木齐市46例、喀什地区1例。现有无症状感染者50例，均在乌鲁木齐市。尚有3016人接受医学观察。\"},{\"user_id\":\"2803301701\",\"screen_name\":\"人民日报\",\"bw_id\":\"4529016474700864\",\"topic\":\"#美国新冠肺炎超381万例# #特朗普称将恢复白宫每日疫情简报会# \",\"created_at\":\"2020-07-21\",\"id\":\"9\",\"reposts_count\":\"1176\",\"wd\":\"新冠\",\"content\":\"【#美国新冠肺炎超381万例#，#特朗普称将恢复白宫每日疫情简报会#】据美国约翰斯·霍普金斯大学发布的全球新冠肺炎数据实时统计系统，截至美国东部时间7月20日晚6时，全美共报告新冠肺炎确诊3814463例，死亡140828例。过去24小时，美国新增确诊54136例，新增死亡362例。\\n美国总统特朗普20日表示，他将恢复举行之前在4月份停止的白宫每日新冠疫情简报会，他可能会在21日下午5点主持新系列吹风会的第一场。他认为，之所以决定重启新闻发布会，不是因为病毒的威胁越来越大，而是因为新闻发布会的电视收视率会很高。“我在做，我们有很多人在观看，观看人数创下了有线电视史上的纪录。这是一个让公众了解我们在疫苗和治疗方面进展的很好方式。”（张梦旭）\"},{\"user_id\":\"2656274875\",\"screen_name\":\"央视新闻\",\"bw_id\":\"4529026544178245\",\"topic\":\"#世卫称实现疫苗公平分配需政治承诺# #公平分配疫苗可让全球摆脱新冠大流行# \",\"created_at\":\"2020-07-21\",\"id\":\"10\",\"reposts_count\":\"725\",\"wd\":\"新冠\",\"content\":\"【#世卫称实现疫苗公平分配需政治承诺#】当地时间20日，世卫组织总干事谭德塞表示，应向贫困人口提供公平获取疫苗的渠道，关键是政治承诺。谭德塞说，越来越多的国家倡议让疫苗成为全球公共产品，但有些国家正逆向而行。#公平分配疫苗可让全球摆脱新冠大流行#，否则经济复苏将延迟，造成更多损失。http:\\/\\/t.cn\\/A6ymfZWt\"}]";
        JSONAssert.assertEquals(answer, result, false);
    }
}
