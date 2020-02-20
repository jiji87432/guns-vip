layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var QxLogon = {
        tableId: "qxLogonTable"
    };

    /**
     * 初始化表格的列
     */
    QxLogon.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '标识'},
            {field: 'version', sort: true, title: '乐观锁'},
            {field: 'createdBy', sort: true, title: '创建人'},
            {field: 'createdTime', sort: true, title: '创建时间'},
            {field: 'updatedBy', sort: true, title: '更新人'},
            {field: 'updatedTime', sort: true, title: '更新时间'},
            {field: 'deleted', sort: true, title: '删除标识'},
            {field: 'userId', sort: true, title: '用户ID'},
            {field: 'logonTime', sort: true, title: '登陆时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    QxLogon.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(QxLogon.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    QxLogon.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/qxLogon/add',
            tableId: QxLogon.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    QxLogon.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/qxLogon/edit?id=' + data.id,
            tableId: QxLogon.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    QxLogon.exportExcel = function () {
        var checkRows = table.checkStatus(QxLogon.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    QxLogon.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/qxLogon/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(QxLogon.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + QxLogon.tableId,
        url: Feng.ctxPath + '/qxLogon/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: QxLogon.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        QxLogon.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        QxLogon.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        QxLogon.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + QxLogon.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            QxLogon.openEditDlg(data);
        } else if (layEvent === 'delete') {
            QxLogon.onDeleteItem(data);
        }
    });
});
