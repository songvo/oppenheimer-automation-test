package com.oppenheimer.pages;

import com.oppenheimer.annotations.Page;

@Page
public class PortalPage extends Base{
    @Override
    public boolean isAt() {
        return false;
    }
}
