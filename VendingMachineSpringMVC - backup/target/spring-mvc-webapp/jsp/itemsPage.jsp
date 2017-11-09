<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">

            <h1>Vending Machine</h1>
            <div class="row" >
                <!--This section is used to display all the items-->
                <div class="col-md-9" id="itemsDiv">
                    <c:forEach var="currentItem" items="${itemsList}" varStatus="loop">
                        <c:if test = "${loop.index}%3 == 0">
                            <div class="row">
                            </c:if>
                            <div class="col-md-3 item">
                                <form method="GET" action="${pageContext.request.contextPath}/displayItem/${currentItem.itemId}">
                                    <button type="submit"
                                            class="btn btn-group-lg">
                                        <p${currentItem.itemId}</p>
                                        <p>${currentItem.name}<br><br>
                                            Quantity left: ${currentItem.quantity}<br>
                                            Price: ${currentItem.price}</p><br>
                                    </button>
                                </form>
                            </div>
                            <c:if test = "${loop.index}%3 == 0">
                            </div>
                        </c:if>
                    </c:forEach>
                </div>

                <!--This section has the operations-->
                <div class="col-md-3">
                    <!--<form class="form-horizontal" role="form" id="amount-form">-->
                    <div class="row form-group" id="cashDiv">
                        <!--This row will hold Total amount heading and display-->
                        <div class="row">
                            <h4>Total $ In</h4>
                            <input type="number"
                                   class="form-control"
                                   id="amt-display"
                                   placeholder="0.00"
                                   step=".01"
                                   value="${total}"
                                   readonly>
                        </div>
                        <br>
                        <!--This section will hold the currency buttons-->
                        <div class="row">
                            <div class="col-lg-6">
                                <form method="POST" action="${pageContext.request.contextPath}/money/dollar">
                                    <button type="submit"
                                            class="btn btn-default form-control">Add Dollar
                                    </button>
                                </form>
                            </div>
                            <div class="col-lg-6">
                                <form method="POST" action="${pageContext.request.contextPath}/money/quarter">
                                    <button type="submit"
                                            class="btn btn-default form-control">Add Quarter
                                    </button>
                                </form>
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-lg-6">
                                <form method="POST" action="${pageContext.request.contextPath}/money/dime">
                                    <button type="submit"
                                            class="btn btn-default form-control">Add Dime
                                    </button>
                                </form>
                            </div>
                            <div class="col-lg-6">
                                <form method="POST" action="${pageContext.request.contextPath}/money/nickel">
                                    <button type="submit"
                                            class="btn btn-default form-control">Add Nickel
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!--</form>-->
                    <div class="row" id="purchaseDiv">
                        <!--Placeholder for messages-->
                        <h4>Messages</h4>
                        <div class="form-group">
                            <input type="text"
                                   value="${message}"
                                   class="form-control"
                                   id="messages"
                                   placeholder="Message"
                                   readonly>
                        </div>
                        <!--Placeholder for item selection-->
                        <div class="row form-group">
                            <div class="col-md-6">
                                <label for="get-item" class="control-label">
                                    Item:
                                </label>
                            </div>
                            <div class="col-md-6">
                                <input type="text"
                                       value="${item.itemId}"
                                       class="form-control"
                                       id="get-item"
                                       placeholder="Select Item"
                                       maxlength="10"
                                       readonly>
                            </div>
                        </div>
                        <div class="row form-group col-md-12">
                            <form method="POST" action="${pageContext.request.contextPath}/purchase/${item.itemId}">
                                <button type="submit"
                                        class="btn btn-default"
                                        >Make Purchase
                                </button>
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <form method="GET" action="${pageContext.request.contextPath}/getChange/">
                            <h4>Change</h4>
                            <div class="row form-group col-md-12">
                                <input type="text"
                                       value="${change}"
                                       id="change"
                                       class="form-control"
                                       placeholder="Change Due"
                                       readonly>
                            </div>
                            <div class="row form-group col-md-12">
                                <button type="submit"
                                        id="change-button"
                                        class="btn btn-default"
                                        >Change Return
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>

