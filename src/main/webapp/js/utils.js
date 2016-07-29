var util = {};

util.customerTips = function autoCustomerTips(selector, callback) {
    $.ajax({
        "url": "background/customer/async/all.html",
        "type": "post",
        "dataType": "json",
        "success": function (data) {
            $(selector).autocomplete(data, {
                max: 0,    //列表里的条目数
                minChars: 0,    //自动完成激活之前填入的最小字符
                // width: 400,     //提示的宽度，溢出隐藏
                scrollHeight: 300,   //提示的高度，溢出显示滚动条
                matchContains: true,    //包含匹配，就是data参数里的数据，是否只要包含文本框里的数据就显示
                autoFill: false,    //自动填充
                formatItem: function (row, i, max) {
                    return row.customerName + "-" + row.cardNo;
                },
                formatMatch: function (row, i, max) {
                    return row.customerName + row.customerNo;
                },
                formatResult: function (row) {
                    return row.customerName + "-";
                }
            }).result(function (event, row, formatted) {
                if (callback) {
                    callback(row, data);
                }
            });
        }
    });
}

util.employeeTips = function autoCustomerTips(selector, callback) {
    $.ajax({
        "url": "background/employee/async/all.html",
        "type": "post",
        "dataType": "json",
        "success": function (data) {
            $(selector).autocomplete(data, {
                max: 0,    //列表里的条目数
                minChars: 0,    //自动完成激活之前填入的最小字符
                // width: 400,     //提示的宽度，溢出隐藏
                scrollHeight: 300,   //提示的高度，溢出显示滚动条
                matchContains: true,    //包含匹配，就是data参数里的数据，是否只要包含文本框里的数据就显示
                autoFill: false,    //自动填充
                formatItem: function (row, i, max) {
                    return row.employeeName;
                },
                formatMatch: function (row, i, max) {
                    return row.employeeName + row.employeeName;
                },
                formatResult: function (row) {
                    return row.employeeName;
                }
            }).result(function (event, row, formatted) {
                if (callback) {
                    callback(row, data);
                }
            });
        }
    });
}