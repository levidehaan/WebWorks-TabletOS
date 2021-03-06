/*
* Copyright 2010-2011 Research In Motion Limited.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package net.rim.tumbler.extension;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class ExtensionDescriptor {

    private boolean _isCopied;
    private String _id;
    private String _entryClass; // for example, "blackberry.pim.PIMExtension"
    private HashSet<String> _dependencies;
    private String _rootFolder; // for example, "C:\\Program Files\\Research In Motion\\BlackBerry Widget Packager\\ExtRepo\\BlackBerry_PIM_Ext"
    private Set<ConfiguredPathname> _configuredPathnames;

    public ExtensionDescriptor(String id, String entryClass, String rootFolder) {
    	_id = id;
        _entryClass = entryClass;
        _rootFolder = rootFolder;
        _configuredPathnames = new LinkedHashSet<ConfiguredPathname>();
    }

    public boolean isCopied() {
        return _isCopied;
    }

    public void markCopied() {
        _isCopied = true;
    }
    
    public String getId() {
    	return _id;
    }

    public String getEntryClass() {
        return _entryClass;
    }
    
    public void addDependency(String extensionId) {
    	if (_dependencies == null) {
    		_dependencies = new HashSet<String>();
    	}
    	
    	_dependencies.add(extensionId);
    }
    
    public HashSet<String> getDependencies() {
    	return _dependencies;
    }

    public String getRootFolder() {
        return _rootFolder;
    }

    public Set<ConfiguredPathname> getConfiguredPathnames() {
        return _configuredPathnames;
    }

    public void addConfiguredPathname(String pathname) {
        _configuredPathnames.add(new ConfiguredPathname(pathname));
    }

    public void addConfiguredPathname(String pathname, String relativeToPackage) {
        _configuredPathnames.add(new ConfiguredPathname(pathname, relativeToPackage));
    }
}
