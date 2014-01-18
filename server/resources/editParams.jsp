<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>

<l:settingsGroup title="Monotouch Build Information">
    <tr>
        <th>
            <label for="monotouch.solution">Solution file path: <l:star/></label>
        </th>
        <td>
            <props:textProperty name="monotouch.solution" className="longField" />
            <bs:vcsTree fieldId="monotouch.solution" />
            <span class="error" id="error_monotouch.solution"></span>
            <span class="smallNote">The specified path should be relative to the checkout directory.</span>
        </td>
    </tr>
    <tr>
        <th>
            <label for="monotouch.configuration">Configuration: <l:star/></label>
        </th>
        <td>
            <props:textProperty name="monotouch.configuration" className="longField" />
            <span class="error" id="error_monotouch.configuration"></span>
            <span class="smallNote">Enter solution configuration to build. ej. "Release|iPhone"</span>
        </td>
    </tr>
</l:settingsGroup>
<l:settingsGroup title="Executable Paths">
    <tr>
        <th>
            <label for="monotouch.mdtoolpath">Xamarin Studio Path: </label>
        </th>
        <td>
            <props:textProperty name="monotouch.mdtoolpath" className="longField"  />
            <span class="smallNote">Where's the Xamarin Studio installed?</span>
        </td>
    </tr>
</l:settingsGroup>