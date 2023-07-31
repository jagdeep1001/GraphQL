package com.airstack.ta.pojos.QueryPojo;

public class pageInfo {
    private String prevCursor;
    private String  nextCursor;


    @Override
    public String toString() {

         return "pageInfo {" +
                 "\n\tprevCursor" +
            "\n\tnextCursor" +
            "\n}";
}

}
